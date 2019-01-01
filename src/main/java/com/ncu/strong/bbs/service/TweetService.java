package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.po.Tweet;

import java.util.List;

public interface TweetService {

    Tweet getTweetById(Integer id);

    List getAllTweets();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Tweet record);

    int updateByPrimaryKeySelective(Tweet record);
}
