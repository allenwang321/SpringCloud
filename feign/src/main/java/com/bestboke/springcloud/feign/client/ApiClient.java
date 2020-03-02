package com.bestboke.springcloud.feign.client;

import com.bestboke.springcloud.feign.pojo.Info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "api")
public interface ApiClient {

    @RequestMapping("/")
    String index();

    @RequestMapping("/info")
    Info info();
}
