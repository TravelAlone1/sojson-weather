package com.lx.spring.cloud.weather.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lx
 * @Date: 2019/10/14 9:45
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
   public String hello(Model model){
       return "Hello Spring Boot";
   }
}
