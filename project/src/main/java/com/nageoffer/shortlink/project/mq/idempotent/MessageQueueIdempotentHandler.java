package com.nageoffer.shortlink.project.mq.idempotent;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:MessageQueueIdempotentHandler
 * Description:
 * 消息队列幂等处理器
 * @Author DubPAN
 * @Create2024/6/19 19:54
 * @Version 1.0
 */
@Component
@RequiredArgsConstructor
public class MessageQueueIdempotentHandler {
    private final StringRedisTemplate stringRedisTemplate;
    private static  final String IDEMPOTENT_KEY_PREFIX = "short-link:idempotent:";

    /**
     * 判断当前消息是否消费过
     *
     * @param messageId 消息唯一标识
     * @return 消息是否消费过
     */
    public boolean isMessageProcessed(String messageId){
        String key = IDEMPOTENT_KEY_PREFIX+messageId;
        //若key(IDEMPOTENT_KEY_PREFIX)存在，则返回false；若不存在，设置IDEMPOTENT_KEY_PREFIX:"",并且设置过期时间为10分钟
        return Boolean.TRUE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key,"",10, TimeUnit.MINUTES));
    }
}
