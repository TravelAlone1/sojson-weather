package com.lx.spring.cloud.weather.Serializer;/**
 * @Author: lx
 * @Date: 2019/10/15 19:05
 */

import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.*;

/**
 * @program: cloud-weather
 *
 * @author: lx
 *
 * @create: 2019-10-15 19:05
 **/
public class RedisObjectSerializer implements RedisSerializer<Object> {

    static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public Object deserialize(byte[] bytes) {
        if (isEmpty(bytes)) {
            return null;
        }
        ObjectInputStream oii = null;
        ByteArrayInputStream bis = null;
        bis = new ByteArrayInputStream(bytes);
        try {
            oii = new ObjectInputStream(bis);
            Object obj = oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] serialize(Object object) {
        if (object == null) {
            return EMPTY_ARRAY;
        }
        ObjectOutputStream obi = null;
        ByteArrayOutputStream bai = null;
        try {
            bai = new ByteArrayOutputStream();
            obi = new ObjectOutputStream(bai);
            obi.writeObject(object);
            byte[] byt = bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
}
