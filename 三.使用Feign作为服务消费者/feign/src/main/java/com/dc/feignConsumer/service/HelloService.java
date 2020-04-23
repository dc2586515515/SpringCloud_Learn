package com.dc.feignConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author DC
 * @Date 2020-04-23
 */
@FeignClient(value = "service-client")
public interface HelloService {

    @RequestMapping("/hi")
    String obtainOtherServerJsonData(@RequestParam(value = "name") String name);

}
