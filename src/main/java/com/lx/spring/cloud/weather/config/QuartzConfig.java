package com.lx.spring.cloud.weather.config;/**
 * @Author: lx
 * @Date: 2019/10/16 20:52
 */

import com.lx.spring.cloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-16 20:52
 **/
@Configuration
public class QuartzConfig {

    private static final int TIME=60*30;

    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDateSyncJob")
                .storeDurably().build(); //使用内部类构建

    }

    //Trigger 指定什么时候做
    @Bean
    public Trigger weatherDataSyncTrigger(){

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }
}
