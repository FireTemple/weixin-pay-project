package com.bohan.mapper;

import com.bohan.entity.videoOrder;

public interface videoOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(videoOrder record);

    int insertSelective(videoOrder record);

    videoOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(videoOrder record);

    int updateByPrimaryKey(videoOrder record);
}