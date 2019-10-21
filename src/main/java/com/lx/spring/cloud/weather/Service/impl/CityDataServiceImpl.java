package com.lx.spring.cloud.weather.Service.impl;/**
 * @Author: lx
 * @Date: 2019/10/20 18:54
 */

import com.lx.spring.cloud.weather.Service.CityDataService;
import com.lx.spring.cloud.weather.util.JsonUtils;
import com.lx.spring.cloud.weather.vo.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-20 18:54
 **/
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        String path="";
        List<City> cities = JsonUtils.readArray("最新_city.json", City.class);
        return cities;
    }
}
