package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户
     * @return
     */
    List findAllUser();

    /**
     * 通过账户id获取用户信息
     * @param id
     * @return
     */
    User getUserProfileByAccoundId(Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 通过id号获取用户信息
     * @param id
     * @return
     */
    User getUserProfileById(Integer id);

    User getTweetsByUser(Integer id);

    User getQuestionsByUser(Integer id);

    User getAnswersByUser(Integer id);

    User getCreateActivity(Integer id);

    User getEnterActivity(Integer id);
}
