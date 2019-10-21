package com.lx.spring.cloud.weather.Service;

import com.lx.spring.cloud.weather.vo.City;

import java.util.List;

/**
 * @Author: lx
 * @Date: 2019/10/20 18:51
 */
public interface CityDataService {

    List<City> listCity() throws Exception;


}
