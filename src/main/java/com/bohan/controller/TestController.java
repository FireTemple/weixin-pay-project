package com.bohan.controller;


import com.bohan.config.WechatConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private WechatConfig wechatConfig;

    @GetMapping("/test")
    public String test(){
        return "bohan study";
    }

    @GetMapping("testConfig")
    public String testConfig(){
        return wechatConfig.getAppId();
    }
}
