package com.bestboke.springcloud.feign.controller;

import com.bestboke.springcloud.feign.client.ApiClient;
import com.bestboke.springcloud.feign.pojo.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private ApiClient apiClient;

    @RequestMapping("/")
    public String index(){
        return apiClient.index();
    }

    @RequestMapping("info")
    public Info info(){
        return apiClient.info();
    }

}
