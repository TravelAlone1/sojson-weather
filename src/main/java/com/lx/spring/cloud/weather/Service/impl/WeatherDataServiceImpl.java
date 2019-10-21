package com.lx.spring.cloud.weather.Service.impl;/**
 * @Author: lx
 * @Date: 2019/10/15 8:49
 */

import com.google.gson.Gson;
import com.lx.spring.cloud.weather.Service.WeatherDataService;
import com.lx.spring.cloud.weather.vo.WeatherResponse;
import com.lx.spring.cloud.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @program: weather
 *
 * @description: WeatherDataService 的实现
 *
 * @author: lx
 *
 * @create: 2019-10-15 08:49
 **/
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private Logger logger = LoggerFactory.getLogger(WeatherDataService.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final Long TIME_OUT=1600L;

    private static final String WEATHER_URL="http://t.weather.sojson.com/api/weather/city/";

    //使用httpClient，注入一个客户端
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url=WEATHER_URL+cityId;
        return doGetWeather(url,cityId);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url=WEATHER_URL+cityName;
        return doGetWeather(url,cityName);
    }

    @Override
    public void syncDataByCityId(String cityId) {
        String url=WEATHER_URL+cityId;
        this.saveWeatherData(url,cityId);

    }

    private void saveWeatherData(String url,String key){


        String body=null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //ValueOperations ops = stringStringValueOperations
        //使用redis做缓存
        //调用服务接口获取数据
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);//无法直接获取响应对象,json字符串
//        if (forEntity.getStatusCodeValue()==200){
////            body = forEntity.getBody();
////        }
        body = this.restTemplatebyIp(url);
        //数据写入缓存
        ops.set(key,body,TIME_OUT, TimeUnit.SECONDS);


    }

    /**
     * 使用代理Ip应对反爬
     */
    public String restTemplatebyIp(String url){
        String body=null;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);//无法直接获取响应对象,json字符串
        if (forEntity.getStatusCodeValue()==200){
            body = forEntity.getBody();
            return body;
        }else {
            SimpleClientHttpRequestFactory schrf = new SimpleClientHttpRequestFactory();
            schrf.setProxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("106.75.212.158", 8080)));
            this.restTemplate.setRequestFactory(schrf);
            if (forEntity.getStatusCodeValue()==200){
                body = forEntity.getBody();

            }
            return body;

        }
    }


    public WeatherResponse doGetWeather(String url,String key){


        String body=null;
        WeatherResponse response=null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //ValueOperations ops = stringStringValueOperations
        //使用redis做缓存
        if (stringRedisTemplate.hasKey(key)){
            logger.info("redis has data");
            body=ops.get(key);
        }else {
//            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);//无法直接获取响应对象,json字符串
//            if (forEntity.getStatusCodeValue()==200){
//                body = forEntity.getBody();
//            }
            body = this.restTemplatebyIp(url);
            logger.info("redis don't data");
            ops.set(key,body,TIME_OUT, TimeUnit.SECONDS);
        }
        Gson gson = new Gson();
        response = gson.fromJson(body, WeatherResponse.class);
        return response;
    }
}
