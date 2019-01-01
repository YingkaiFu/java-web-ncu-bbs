package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.ActivityEnterMapper;
import com.ncu.strong.bbs.po.ActivityEnter;
import com.ncu.strong.bbs.service.ActivityEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityEnterServiceImpl implements ActivityEnterService {

    @Autowired
    private ActivityEnterMapper activityEnterMapper;

    @Override
    public int insert(ActivityEnter record) {
        return activityEnterMapper.insert(record);
    }
}
