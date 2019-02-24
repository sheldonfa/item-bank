package com.mypro.ssm.service.impl;

import com.mypro.ssm.mapper.QuestionMapper;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.service.QuestionService;
import com.mypro.ssm.util.Ebbinghaus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public Integer add(Question question) {
        return questionMapper.insertSelective(question);
    }

    @Override
    public Integer update(Question question) {
        return questionMapper.updateByPrimaryKeySelective(question);
    }

    @Override
    public List<Question> findAll() {
        return questionMapper.selectAll();
    }

    @Override
    public List<Question> findNeedReviews() {
        List<Question> result = new ArrayList<>();
        List<Question> questions = questionMapper.selectAll();
        for (int i = 0; i < questions.size(); i++) {
            if (Ebbinghaus.needRecite(questions.get(i))) {
                result.add(questions.get(i));
            }
        }
        return result;
    }

    @Override
    public Question findById(Long id) {
        Question question = new Question();
        question.setId(id);
        return questionMapper.selectOne(question);
    }

    @Override
    public Integer delete(Long id) {
        Question question = new Question();
        question.setId(id);
        return questionMapper.deleteByPrimaryKey(question);
    }
}
