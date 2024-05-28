package com.nageoffer.shortlink.admin.common.biz.user;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Objects;

import static com.nageoffer.shortlink.admin.common.constant.RedisCacheConstant.USER_LOGIN_KEY;

/**
 * ClassName:UserTransmitFilter
 * Description:
 * 用户信息传输过滤器
 * @Author DubPAN
 * @Create2024/5/27 17:00
 * @Version 1.0
 */
@Slf4j
@RequiredArgsConstructor
public class UserTransmitFilter implements Filter {

    private final StringRedisTemplate stringRedisTemplate;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI =httpServletRequest.getRequestURI();
        if(!Objects.equals(requestURI,"/api/short-link/admin/v1/user/login")){//忽略登录url
            String username = httpServletRequest.getHeader("username");
            String token = httpServletRequest.getHeader("token");
            Object userInfoJsonStr = stringRedisTemplate.opsForHash().get(USER_LOGIN_KEY + username, token);
            if (userInfoJsonStr!=null) {
                UserInfoDTO userInfoDTO = JSON.parseObject(userInfoJsonStr.toString(),UserInfoDTO.class);
                UserContext.setUser(userInfoDTO);
            }
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.removeUser();//删除线程里用户信息，防止内存泄露
        }
    }
}