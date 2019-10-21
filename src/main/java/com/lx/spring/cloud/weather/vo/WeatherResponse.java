package com.lx.spring.cloud.weather.vo;/**
 * @Author: lx
 * @Date: 2019/10/15 21:51
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-15 21:51
 **/
@Data
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 4894072926636368372L;

    private String message;

    private Integer status;

    private String date;

    private String time;

    private CityInfo cityInfo;

    private WeatherData data;


}
