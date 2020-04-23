package com.dc.feignConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author DC
 * @Date 2020-04-23
 */
@FeignClient(value = "service-client", fallback = ErrorHandler.class)
public interface HelloService {
    // 这里的请求路径要与 service-client 保持完全一致
    @RequestMapping("/hi")
    String obtainOtherServerJsonData(@RequestParam(value = "name") String name);

}
