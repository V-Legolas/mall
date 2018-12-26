package com.mardoner.mall.admin.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
* @Description:  Json 序列化/反序列化工具
* @ClassName: JsonUtils
* @author whuan-QQ:2500119268
* @email: mardoner12p@gmail.com
* @date 2018/12/20 11:23
* @Version 1.0
*/
public class JsonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    /** jackson 对象 */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonUtils(){
        throw new AssertionError();
    }

    /** 对象转化成json */
    public static String objToJson(Object data){
        try {
            String str = MAPPER.writeValueAsString(data);
            return str;
        } catch (JsonProcessingException e) {
            LOGGER.warn("JsonUtils.objToJson()",e);
        }
        return null;
    }

    /** json结果集转化为对象 */
    public static <T> T jsonToObj(String jsonData,Class<T> beanType){
        try {
            T t = MAPPER.readValue(jsonData,beanType);
        } catch (IOException e) {
            LOGGER.warn("JsonUtils.jsonToObj()",e);
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            LOGGER.warn("JsonUtils.jsonToObj()",e);
        }
        return null;
    }
}
