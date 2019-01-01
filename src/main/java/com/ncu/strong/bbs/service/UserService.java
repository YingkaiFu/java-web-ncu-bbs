package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.po.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户
     */
    List<User> findAllUser();

    /**
     * 通过账户id获取用户信息
     */
    User getUserProfileByAccoundId(Integer id);

    /**
     * 添加用户
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     */
    int updateUser(User user);

    /**
     * 通过id号获取用户信息
     */
    User getUserProfileById(Integer id);

    User getTweetsByUser(Integer id);

    User getQuestionsByUser(Integer id);

    User getAnswersByUser(Integer id);

    User getCreateActivity(Integer id);

    User getEnterActivity(Integer id);
}