package com.lx.spring.cloud.weather.Service;

import com.lx.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.stereotype.Service;

/**
 * @Author: lx
 * @Date: 2019/10/14 18:27
 */

public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

    void syncDataByCityId(String cityId);
}
