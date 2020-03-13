package com.bohan.service.impl;

import com.bohan.entity.Video;
import com.bohan.mapper.VideoMapper;
import com.bohan.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;


    @Override
    public List<Video> findAll() {
        return videoMapper.findAll();
    }
}
