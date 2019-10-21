package com.lx.spring.cloud.weather.job;/**
 * @Author: lx
 * @Date: 2019/10/16 21:55
 */

import com.google.common.base.Strings;
import com.lx.spring.cloud.weather.Service.CityDataService;
import com.lx.spring.cloud.weather.Service.WeatherDataService;
import com.lx.spring.cloud.weather.util.JsonUtils;
import com.lx.spring.cloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-16 21:55
 **/
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    private Logger logger= LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Job");

        List<City> cityList=null;

        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            logger.error("Exception!" + e);
        }
        for (City city: cityList){
            String cityId=city.getCityCode();
            if (!Strings.isNullOrEmpty(cityId)){

                logger.info("Weather Data Sync Job"+cityId);
                weatherDataService.syncDataByCityId(cityId);
                try {
                    Thread.sleep(1000*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
