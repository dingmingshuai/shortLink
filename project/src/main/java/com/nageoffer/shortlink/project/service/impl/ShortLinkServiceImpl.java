package com.nageoffer.shortlink.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mchange.lang.ShortUtils;
import com.nageoffer.shortlink.project.ShortLinkApplication;
import com.nageoffer.shortlink.project.common.convention.exception.ServiceException;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import com.nageoffer.shortlink.project.dao.mapper.ShortLinkMapper;
import com.nageoffer.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.nageoffer.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.nageoffer.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.nageoffer.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.nageoffer.shortlink.project.service.ShortLinkService;
import com.nageoffer.shortlink.project.toolkit.HashUtil;
import io.reactivex.rxjava3.internal.operators.completable.CompletableUsing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.exception.metadata.DuplicatedIndexException;
import org.redisson.api.RBloomFilter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * ClassName:ShortLinkServiceimpl
 * Description:
 * 短链接接口实现层
 * @Author DubPAN
 * @Create2024/5/28 17:04
 * @Version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {
    private  final RBloomFilter<String> shortUricachePenetrationBloomFilter;
    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam) {
        String shortLinkSuffix = generateSuffix(requestParam);
        String fullShortUrl =requestParam.getDomain()+"/"+shortLinkSuffix;//短链接->(协议):域名/后缀 (此处域名包含协议http/https)
        ShortLinkDO shortLinkDO = ShortLinkDO.builder()
                .domain(requestParam.getDomain())
                .originUrl(requestParam.getOriginUrl())
                .gid(requestParam.getGid())
                .createdType(requestParam.getCreatedType())
                .validDateType(requestParam.getValidDateType())
                .validDate(requestParam.getValidDate())
                .describe(requestParam.getDescribe())
                .shortUri(shortLinkSuffix)
                .enableStatus(0)
                .fullShortUrl(fullShortUrl)
                .build();
        try {
            baseMapper.insert(shortLinkDO);
        }catch (DuplicateKeyException ex){//创建短链接时防止布隆过滤器误判(返回存在，可能不存在)，使用Mysql的key冲突判断
            //已经误判的短链接如何处理？查数据库确认是否存在
            LambdaQueryWrapper<ShortLinkDO> queryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                    .eq(ShortLinkDO::getFullShortUrl, fullShortUrl);
            ShortLinkDO hasShortLinkDO = baseMapper.selectOne(queryWrapper);
            if (hasShortLinkDO!=null){//数据库确认存在
                log.warn("短链接{}重复入库！",fullShortUrl);
                throw new ServiceException("短链接生成重复！");
            }
        }
        shortUricachePenetrationBloomFilter.add(fullShortUrl);//将创建的短链接加入布隆过滤器
        return ShortLinkCreateRespDTO.builder()
                .fullShortUrl(shortLinkDO.getFullShortUrl())
                .originUrl(requestParam.getOriginUrl())
                .gid(requestParam.getGid())
                .build();
    }

    @Override
    public IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam) {
        LambdaQueryWrapper<ShortLinkDO> queryWrapper = Wrappers.lambdaQuery(ShortLinkDO.class)
                .eq(ShortLinkDO::getGid, requestParam.getGid())
                .eq(ShortLinkDO::getEnableStatus, 0)
                .eq(ShortLinkDO::getDelFlag, 0)
                .orderByDesc(ShortLinkDO::getCreateTime);
        IPage<ShortLinkDO> resultPage  = baseMapper.selectPage(requestParam, queryWrapper);
        return resultPage.convert(each -> BeanUtil.toBean(each,ShortLinkPageRespDTO.class));
    }

    /**
     * 生成短链接后缀
     * @param requestParam
     * @return
     */
    private String generateSuffix(ShortLinkCreateReqDTO requestParam){
        int costomGenerateCount =0;//冲突后最大重试次数
        String shortUri ;
        while (true){
            if(costomGenerateCount>10){
                throw new SecurityException("短链接频繁生成，请稍后再试！");
            }
            String originUrl = requestParam.getOriginUrl();
            originUrl+=System.currentTimeMillis();//相当于加盐，生成新的shortUri，降低哈希冲突概率
            shortUri=HashUtil.hashToBase62(originUrl);
            //使用布隆过滤器防止直接查询数据库,验证短链接是否冲突（重复）
            if(!shortUricachePenetrationBloomFilter.contains(requestParam.getDomain() + "/" + shortUri)){
                break;//新的ShortUri，不冲突，保留
            }
            costomGenerateCount++;//冲突，冲突次数++
        }
        return shortUri;
    }
}
