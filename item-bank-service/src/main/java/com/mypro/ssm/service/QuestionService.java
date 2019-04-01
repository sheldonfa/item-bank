package com.mypro.ssm.service;

import com.mypro.exception.BusinessException;
import com.mypro.ssm.query.QuestionQuery;
import com.mypro.ssm.po.Question;

import java.util.List;

public interface QuestionService {

    Integer add(Question question);

    Integer update(Question question);

    List<Question> findAll();

    List<Question> findNeedReviews();

    Question findById(Long id);

    Integer delete(Long id);

    void remember(Long id,Boolean isRemember);

    List<Question> findByCategory(Long categoryId);

    void updateByIds(QuestionQuery query) throws BusinessException;
}
