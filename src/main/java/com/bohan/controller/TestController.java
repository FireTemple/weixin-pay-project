package com.bohan.controller;


import com.bohan.config.WechatConfig;
import com.bohan.entity.Video;
import com.bohan.service.impl.VideoServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testPageHelper")
    public PageInfo<Video> testPageHelper(@RequestParam(value = "page", defaultValue = "1")int page,
                                          @RequestParam(value = "size", defaultValue = "10")int size){
        PageHelper.startPage(page, size);
        List<Video> videos = videoService.findAll();
        PageInfo<Video> pageInfo = new PageInfo<>(videos);
        return pageInfo;

    }
}
