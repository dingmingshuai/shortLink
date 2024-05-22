package com.nageoffer.shortlink.admin.config;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:RBloomFilterConfiguration
 * Description:
 * 布隆过滤器配置
 * @Author DubPAN
 * @Create2024/5/20 16:47
 * @Version 1.0
 */
@Configuration
public class RBloomFilterConfiguration {

    /**
     * 防止用户注册查询数据库的布隆过滤器
     */
    @Bean
    public RBloomFilter<String> userRegisterCachePenetrationBloomFilter(RedissonClient redissonClient) {
        RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter("userRegisterCachePenetrationBloomFilter");//布隆过滤器命名
        cachePenetrationBloomFilter.tryInit(100000000L, 0.001);//预估布隆过滤器存储的元素长度，运行的误判率
        return cachePenetrationBloomFilter;
    }
}
