package com.lx.spring.cloud.weather.util;/**
 * @Author: lx
 * @Date: 2019/10/20 15:15
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.google.gson.Gson;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-20 15:15
 **/
public class JsonUtils {

    public static <T> T readJsonFromClassPath(String path, Type type) throws IOException {

        ClassPathResource resource = new ClassPathResource(path);
        Gson gson = new Gson();
        if (resource.exists()) {


            return JSON.parseObject(resource.getInputStream(), StandardCharsets.UTF_8, type,
                    // 自动关闭流
                    Feature.AutoCloseSource,
                    // 允许注释
                    Feature.AllowComment,
                    // 允许单引号
                    Feature.AllowSingleQuotes,
                    // 使用 Big decimal
                    Feature.UseBigDecimal);
        } else {
            throw new IOException();
        }
     }


    public static <T> List<T> readArray(String path, Class<T> t) throws IOException {


        ClassPathResource resource = new ClassPathResource(path);
        if (resource.exists()) {
            InputStream stream = resource.getInputStream();
            byte[] bytes = new byte[stream.available()];
            stream.read(bytes);
            return JSON.parseArray(new String(bytes), t);
        } else {
            throw new IOException();
        }
    }



}
