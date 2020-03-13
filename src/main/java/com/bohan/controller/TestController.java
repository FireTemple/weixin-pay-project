package com.bohan.controller;


import com.bohan.config.WechatConfig;
import com.bohan.entity.Video;
import com.bohan.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private VideoServiceImpl videoService;

    @GetMapping("/test")
    public String test(){
        return "bohan study";
    }

    @GetMapping("/testConfig")
    public String testConfig(){
        return wechatConfig.getAppId();
    }

    @GetMapping("/testVideo")
    public List<Video> testVideo(){
        return videoService.findAll();
    }
}
