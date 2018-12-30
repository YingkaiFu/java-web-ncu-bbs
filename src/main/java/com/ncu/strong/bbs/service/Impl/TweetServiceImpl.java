package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.TweetMapper;
import com.ncu.strong.bbs.pojo.Tweet;
import com.ncu.strong.bbs.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetMapper tweetDao;

    @Override
    public Tweet getTweetById(Integer id) {
        return tweetDao.getTweetById(id);
    }

    @Override
    public List getAllTweets() {
        return tweetDao.getAllTweets();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tweetDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Tweet record) {
        return tweetDao.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Tweet record) {
        return tweetDao.updateByPrimaryKeySelective(record);
    }


}
