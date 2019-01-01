package com.ncu.strong.bbs.service.Impl;

import com.ncu.strong.bbs.dao.QuestionMapper;
import com.ncu.strong.bbs.po.Question;
import com.ncu.strong.bbs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionDao;
    @Override
    public int insert(Question record) {
        return questionDao.insert(record);
    }

    @Override
    public int delete(Integer id) {
        return questionDao.deleteByPrimaryKey(id);
    }

    @Override
    public List getHostQuestion() {
        return questionDao.getHostQuestion();
    }

    @Override
    public List getLatestQuestion() {
        return questionDao.getLatestQuestion();
    }

    @Override
    public Question getQuestionById(Integer id) {

        questionDao.updateClick(id);
        return questionDao.getQuestionById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Question record) {
        return questionDao.updateByPrimaryKeySelective(record);
    }
}
