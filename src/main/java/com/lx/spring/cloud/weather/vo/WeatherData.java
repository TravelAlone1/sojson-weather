package com.lx.spring.cloud.weather.vo;/**
 * @Author: lx
 * @Date: 2019/10/15 22:00
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-15 22:00
 **/
@Data
public class WeatherData implements Serializable {

    private static final long serialVersionUID = -8384334939458481034L;

    private String shidu;

    private Integer pm25;

    private Integer pm10;

    private String quality;

    private String wendu;

    private String ganmao;

    private List<Forecast> forecast;


}
