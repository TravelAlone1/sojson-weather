package com.lx.spring.cloud.weather.vo;/**
 * @Author: lx
 * @Date: 2019/10/15 22:05
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @program: sojson-weather
 * @author: lx
 * @create: 2019-10-15 22:05
 **/
@Data
public class Forecast implements Serializable {

    private static final long serialVersionUID = 1796841191936456470L;

    private String date;

    private String high;

    private String low;

    private String ymd;

    private String week;

    private String sunrise;

    private String sunset;

    private Integer aqi;

    private String fx;

    private String fl;

    private String type;

    private String notice;
}
