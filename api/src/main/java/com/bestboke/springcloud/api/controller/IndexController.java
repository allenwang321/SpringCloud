package com.bestboke.springcloud.api.controller;

import com.bestboke.springcloud.api.pojo.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class IndexController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/")
    public String index(HttpSession session, HttpServletRequest request){
        return getInfo().toString() + ":" + request.getSession().getId();
    }

    @RequestMapping("/info")
    public Info info(HttpSession session){
        session.setAttribute("ok", "ok");
        return getInfo();
    }

    private Info getInfo(){
        try {
            return new Info(InetAddress.getLocalHost().getHostName(), port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

}
