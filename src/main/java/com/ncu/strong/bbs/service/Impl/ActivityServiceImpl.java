package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.ActivityMapper;
import com.ncu.strong.bbs.po.Activity;
import com.ncu.strong.bbs.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int insert(Activity record) {
        return activityMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return activityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Activity record) {
        return activityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Activity getActivityById(Integer id) {
        return activityMapper.getActivity(id);
    }

    @Override
    public List getHostActivity() {
        return activityMapper.getHostActivity();
    }

    @Override
    public List getLatestActivity() {
        return activityMapper.getLatestActivity();
    }
}
