package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.AnswerMapper;
import com.ncu.strong.bbs.po.Answer;
import com.ncu.strong.bbs.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public int insert(Answer record) {
        return answerMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return answerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Answer record) {
        return answerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Answer getAnswerById(Integer id) {
        return answerMapper.getAnswerById(id);
    }

}
