package com.lx.spring.cloud.weather.vo;/**
 * @Author: lx
 * @Date: 2019/10/20 14:29
 */

import lombok.Data;
import sun.misc.IOUtils;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-20 14:29
 **/
@Data
public class City {

    private Integer id;

    private Integer pid;

    private String cityCode;

    private String cityName;

    private String postCode;

    private String areaCode;

    private String ctime;


}
