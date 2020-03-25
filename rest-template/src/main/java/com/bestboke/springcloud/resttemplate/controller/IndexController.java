package com.bestboke.springcloud.resttemplate.controller;

import com.bestboke.springcloud.resttemplate.pojo.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/")
    public String index() {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("API");
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort());
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }

    @RequestMapping("/info")
    public Info info() {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("API");
        String url = String.format("http://%s:%s/info", serviceInstance.getHost(), serviceInstance.getPort());
        Info response = restTemplate.getForObject(url, Info.class);
        return response;
    }

    @RequestMapping("info-new")
    public Info infoNew(){
        return restTemplate.getForObject("http://API/info", Info.class);
    }

}
