package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.AnswerMapper;
import com.ncu.strong.bbs.pojo.Answer;
import com.ncu.strong.bbs.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerDao;
    @Override
    public int insert(Answer record) {
        return answerDao.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return answerDao.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Answer record) {
        return answerDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public Answer getAnswerById(Integer id) {
        return answerDao.getAnswerById(id);
    }

}
