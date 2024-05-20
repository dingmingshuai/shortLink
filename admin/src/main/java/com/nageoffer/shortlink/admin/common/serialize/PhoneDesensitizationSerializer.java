package com.nageoffer.shortlink.admin.common.serialize;

import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * ClassName:PhoneDesensitizationSerializer
 * Description:
 * 手机号脱敏反序列化
 * @Author DubPAN
 * @Create2024/5/20 15:17
 * @Version 1.0
 */
public class PhoneDesensitizationSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String phone, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String phoneDesensitization = DesensitizedUtil.mobilePhone(phone);//使用Jackson原生注解序列化-->154****0350
        jsonGenerator.writeString(phoneDesensitization);
    }
}
