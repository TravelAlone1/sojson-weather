package com.lx.spring.cloud.weather.vo;/**
 * @Author: lx
 * @Date: 2019/10/15 21:55
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @program: sojson-weather
 * @author: lx
 * @create: 2019-10-15 21:55
 **/
@Data
public class CityInfo implements Serializable {

    private static final long serialVersionUID = -1431366234621130145L;

    private String city;

    private String cityKey;

    private String parent;

    private String updateTime;
}
