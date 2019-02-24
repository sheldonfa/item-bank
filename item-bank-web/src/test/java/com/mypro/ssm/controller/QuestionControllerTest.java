package com.mypro.ssm.controller;

import com.mypro.ssm.mapper.QuestionMapper;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.service.QuestionService;
import com.mypro.ssm.util.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    @Before
    public void setUp() {
        questionMapper.deleteAll();
        // Setup初始化数据
        for (int i = 0; i < 24; i++) {
            Question question = new Question(1, "asdf", 1, DateUtils.stringToDate("2019-02-04 10:00:00", "yyyy-MM-dd HH:mm:ss"));
            questionService.add(question);
        }
    }

    @Test
    public void findNeedReviews() {
        List<Question> reviews = questionService.findNeedReviews();
        Assert.assertNotEquals(0, reviews.size());
    }

    @Test
    public void testAdd() {
        Question question = new Question();
        question.setCategoryId(1);
        question.setContent("adsfds");
        questionService.add(question);
    }
}
