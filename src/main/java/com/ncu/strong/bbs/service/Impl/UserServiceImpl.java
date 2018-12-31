package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.UserMapper;
import com.ncu.strong.bbs.pojo.User;
import com.ncu.strong.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public List findAllUser(){
        return userDao.findAllUser();
    }

    @Override
    public User getUserProfileByAccoundId(Integer id) {
        return userDao.selectByAccountId(id);
    }

    @Override
    public int insertUser(User user) {
        if(userDao.insert(user) == 1){
            return 1;
        }
        return 0;
    }

    @Override
    public int updateUser(User user){
        if(userDao.updateByPrimaryKeySelective(user) == 1){
            return 1;
        }
        return 0;
    }

    @Override
    public User getUserProfileById(Integer id){
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public User getTweetsByUser(Integer id) {
        return userDao.getTweetsByUser(id);
    }

    @Override
    public User getQuestionsByUser(Integer id) {
        return userDao.getQuestionsByUser(id);
    }

    @Override
    public User getAnswersByUser(Integer id) {
        return userDao.getAnswersByUser(id);
    }

    @Override
    public User getCreateActivity(Integer id) {
        return userDao.getCreateActivity(id);
    }

    @Override
    public User getEnterActivity(Integer id) {
        return userDao.getEnterActivity(id);
    }

}
