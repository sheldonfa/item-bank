package com.mypro.ssm.service.impl;

import com.mypro.exception.BusinessException;
import com.mypro.ssm.common.CodeMsg;
import com.mypro.ssm.mapper.QuestionMapper;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.query.QuestionQuery;
import com.mypro.ssm.service.CategoryService;
import com.mypro.ssm.service.QuestionService;
import com.mypro.util.Ebbinghaus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private CategoryService categoryService;

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
        return findNeedReviews(null, false);
    }

    @Override
    public List<Question> findNeedReviews(Long categoryId, Boolean recursion) {
        List<Question> result = new ArrayList<>();
        List<Question> questions;
        if (categoryId == null) {
            questions = findAll();
        } else {
            questions = findByCategoryId(categoryId, recursion);
        }
        for (Question question : questions) {
            if (Ebbinghaus.needRecite(question)) {
                result.add(question);
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
    public void remember(Long id, Boolean isRemember) {
        Question question = questionMapper.findById(id);
        if (isRemember) {
            question.setStage(question.getStage() + 1);
        }
        question.setLastReviewTime(new Date());
        questionMapper.update(question);
    }

    @Override
    public List<Question> findByCategoryId(Long categoryId) {
        return findByCategoryId(categoryId, false);
    }

    @Override
    public List<Question> findByCategoryId(Long categoryId, Boolean recuvre) {
        List<Question> results = questionMapper.findByCategory(categoryId);
        if (recuvre) {
            List<Long> categories = categoryService.findAllChildrenId(categoryId);
            for (Long cid : categories) {
                List<Question> questions = questionMapper.findByCategory(cid);
                results.addAll(questions);
            }
        }
        return results;
    }

    @Override
    public Long findCountByCategory(Long categoryId, Boolean recursion) {
        return findCountByCategory(categoryId, recursion, 1);
    }

    @Override
    public Long findCountByCategory(Long categoryId, Boolean recursion, Integer countType) {
        if (countType == 1) {
            Question question = new Question();
            question.setCategoryId(categoryId);
            Long sum = questionMapper.findCount(question);
            if (recursion) {
                List<Long> ids = categoryService.findAllChildrenId(categoryId);
                for (Long cid : ids) {
                    Question question2 = new Question();
                    question2.setCategoryId(cid);
                    Long count = questionMapper.findCount(question2);
                    sum += count;
                }
            }
            return sum;
        }
        // 查询需要复习的数量
        else if (countType == 2) {
            List<Question> needReviews = this.findNeedReviews(categoryId, recursion);
            Integer size = needReviews.size();
            return size.longValue();
        }
        return null;
    }

    @Override
    public void updateByIds(QuestionQuery query) throws BusinessException {
        List<Category> children = categoryService.findChildren(query.getCategoryId());
        if (children != null && children.size() > 0) {
            throw new BusinessException(CodeMsg.NOT_LEAF_CATEGORY_EXCEPTION);
        }
        for (Long id : query.getIds()) {
            Question question = new Question();
            question.setId(id);
            question.setCategoryId(query.getCategoryId());
            questionMapper.update(question);
        }
    }
}
