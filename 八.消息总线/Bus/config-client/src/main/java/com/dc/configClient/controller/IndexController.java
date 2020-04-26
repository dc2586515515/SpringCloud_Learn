package com.dc.configClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author DC
 * @Date 2020-04-23
 */
@RestController
@RefreshScope
public class IndexController {
    @Value("${jay.label}")
    private String label;

    @RequestMapping("/hello")
    public String test() {
        return label;
    }
}
