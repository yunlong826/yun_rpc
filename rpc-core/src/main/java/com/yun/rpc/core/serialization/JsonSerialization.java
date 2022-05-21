package com.yun.rpc.core.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO Json序列化
 * @date 2022/5/21 18:56
 */
public class JsonSerialization implements RpcSerialization{
    private static final ObjectMapper MAPPER;
    static{
        MAPPER = generateMapper(JsonInclude.Include.ALWAYS);
    }

    private static ObjectMapper generateMapper(JsonInclude.Include always) {
        ObjectMapper customMapper = new ObjectMapper();
        customMapper.setSerializationInclusion(always);
        customMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        customMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
        customMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        return customMapper;
    }

    @Override
    public <T> byte[] serialize(T obj) throws Exception {
        return obj instanceof String ? ((String) obj).getBytes() : MAPPER.writeValueAsString(obj).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clz) throws Exception {
        return MAPPER.readValue(Arrays.toString(data), clz);
    }
}
