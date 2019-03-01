package com.mypro.ssm.service.impl;

import com.mypro.ssm.mapper.QuestionMapper;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.service.QuestionService;
import com.mypro.ssm.util.Ebbinghaus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        return questionMapper.update(question);
    }

    @Override
    public List<Question> findAll() {
        return questionMapper.findAll();
    }

    @Override
    public List<Question> findNeedReviews() {
        List<Question> result = new ArrayList<>();
        List<Question> questions = questionMapper.findAll();
        for (int i = 0; i < questions.size(); i++) {
            if (Ebbinghaus.needRecite(questions.get(i))) {
                result.add(questions.get(i));
            }
        }
        return result;
    }

    @Override
    public Question findById(Long id) {
        return questionMapper.findById(id);
    }

    @Override
    public Integer delete(Long id) {
        return questionMapper.deleteById(id);
    }

    @Override
    public void remember(Long id,Boolean isRemember) {
        Question question = questionMapper.findById(id);
        if(isRemember){
            question.setStage(question.getStage() + 1);
        }
        question.setLastReviewTime(new Date());
        questionMapper.update(question);
    }
}
