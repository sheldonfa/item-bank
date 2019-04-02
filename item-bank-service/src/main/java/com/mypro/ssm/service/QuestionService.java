package com.mypro.ssm.service;

import com.mypro.exception.BusinessException;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.query.QuestionQuery;

import java.util.List;

public interface QuestionService {

    Integer add(Question question);

    Integer update(Question question);

    List<Question> findAll();

    /**
     * 查询全部需要复习的question
     *
     * @return
     */
    List<Question> findNeedReviews();

    /**
     * 查询全部需要复习的question
     *
     * @param categoryId 分类id
     * @param recursion 是否递归查询
     * @return
     */
    List<Question> findNeedReviews(Long categoryId, Boolean recursion);

    Question findById(Long id);

    Integer delete(Long id);

    void remember(Long id, Boolean isRemember);

    /**
     * @param categoryId
     * @return
     */
    List<Question> findByCategoryId(Long categoryId);

    /**
     * 根据categoryId查询question列表
     *
     * @param categoryId
     * @param recurve    递归查询
     * @return
     */
    List<Question> findByCategoryId(Long categoryId, Boolean recurve);

    /**
     * 根据categoryId查询question数量
     *
     * @param categoryId
     * @param recursion  递归查询
     * @return
     */
    Long findCountByCategory(Long categoryId, Boolean recursion);

    /**
     * 根据categoryId查询question数量
     *
     * @param categoryId
     * @param recursion
     * @param countType  数量类型 1 查询全部 2 查询需要复习的
     * @return
     */
    Long findCountByCategory(Long categoryId, Boolean recursion, Integer countType);

    void updateByIds(QuestionQuery query) throws BusinessException;
}
