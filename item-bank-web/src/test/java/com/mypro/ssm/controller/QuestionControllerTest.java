package com.mypro.ssm.controller;

import com.mypro.ssm.mapper.QuestionMapper;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.service.QuestionService;
import com.mypro.ssm.util.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/applicationContext-*"})
public class QuestionControllerTest {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionService questionService;

    @Test
    public void findNeedReviews() {
        List<Question> reviews = questionService.findNeedReviews();
        Assert.assertNotEquals(0, reviews.size());
    }

    @Test
    @Rollback
    public void testAdd() {
        Question question = new Question();
        question.setCategoryId(1L);
        question.setContent("adsfds");
        questionService.add(question);
    }
}
