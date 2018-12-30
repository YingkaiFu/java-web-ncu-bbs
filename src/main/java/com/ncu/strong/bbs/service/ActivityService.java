package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.pojo.Activity;

import java.util.List;

public interface ActivityService {

    int insert(Activity record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    Activity getActivityById(Integer id);

    List getHostActivity();

    List getLatestActivity();
}
