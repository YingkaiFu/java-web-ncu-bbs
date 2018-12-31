package com.ncu.strong.bbs.service;

import com.ncu.strong.bbs.pojo.Answer;

public interface AnswerService {

    int insert(Answer record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Answer record);

    Answer getAnswerById(Integer id);
}
