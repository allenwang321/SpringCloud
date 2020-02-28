package com.bestboke.springcloud.api.controller;

import com.bestboke.springcloud.api.pojo.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class IndexController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/")
    public String index(){
        return getInfo().toString();
    }

    @RequestMapping("/info")
    public Info info(){
        return getInfo();
    }

    private Info getInfo(){
        try {
            return new Info(InetAddress.getLocalHost().getHostAddress(), port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

}
