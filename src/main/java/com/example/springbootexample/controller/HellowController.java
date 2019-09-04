package com.example.springbootexample.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootexample.domain.CityModel;
import com.example.springbootexample.service.ExampleServiceImpl;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * ClassName:
 * Description:
 * date: 2019/8/8 0008 21:26
 *
 * @author SS
 * @since JDK 1.8
 */

@RestController
//@ConfigurationProperties(prefix = "person")
//@PropertySource(value = {"classpath:application.yml"},ignoreResourceNotFound = false,encoding = "UTF-8")
public class HellowController {


    @Autowired
    ExampleServiceImpl exampleService;
   // @Value("${age}")
    //private Integer age;
   // @Value("${name}")
   // private String name;
    @RequestMapping("/hello")
    public CityModel hello(){
        ArrayList<CityModel> arrayList = exampleService.queryDate();
        System.err.println("result:"+arrayList.get(20));
        CityModel cityModel = arrayList.get(0);
        return cityModel;
        //return  "static/hello3";
    }
}
