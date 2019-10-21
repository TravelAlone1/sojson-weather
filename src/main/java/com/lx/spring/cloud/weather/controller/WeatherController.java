package com.lx.spring.cloud.weather.controller;/**
 * @Author: lx
 * @Date: 2019/10/15 11:10
 */

import com.lx.spring.cloud.weather.Service.WeatherDataService;
import com.lx.spring.cloud.weather.global.Result;
import com.lx.spring.cloud.weather.global.ResultCode;
import com.lx.spring.cloud.weather.util.JsonUtils;
import com.lx.spring.cloud.weather.vo.City;
import com.lx.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @program: weather
 *
 * @author: lx
 *
 * @create: 2019-10-15 11:10
 **/
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("cityId/{cityId}")
    public Result getWeatherByCityId(@PathVariable("cityId") String cityId){
        WeatherResponse dataByCityId = weatherDataService.getDataByCityId(cityId);
        Result result = new Result(ResultCode.SUCCESS, null);
        return result;
    }

    @GetMapping("cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
        WeatherResponse dataByCityName = weatherDataService.getDataByCityName(cityName);
        return dataByCityName;
    }


}
