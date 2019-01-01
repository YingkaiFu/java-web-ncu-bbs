package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.po.Question;

import java.util.List;

public interface QuestionServie {

    int insert(Question record);

    int delete(Integer id);

    List getHostQuestion();

    List getLatestQuestion();

    Question getQuestionById(Integer id);

    int updateByPrimaryKeySelective(Question record);
}
