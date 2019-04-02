package com.mypro.ssm.query;

import com.mypro.ssm.po.Question;

import java.util.List;

public class QuestionQuery extends Question {
    /**
     * ids
     */
    private List<Long> ids;
    /**
     * categoryId
     */
    private Long categoryId;
    /**
     * 是否记住
     */
    private Boolean rememberFlag;

    /**
     * 是否递归
     *
     * @return
     */
    private Boolean recursion = false;

    /**
     * 查询question数量的类型
     * 1 查全部数量
     * 2 查需要复习的数量
     *
     * @return
     */
    private Integer countType = 1;

    public Integer getCountType() {
        return countType;
    }

    public void setCountType(Integer countType) {
        this.countType = countType;
    }

    public Boolean getRecursion() {
        return recursion;
    }

    public void setRecursion(Boolean recursion) {
        this.recursion = recursion;
    }

    public Boolean getRememberFlag() {
        return rememberFlag;
    }

    public void setRememberFlag(Boolean rememberFlag) {
        this.rememberFlag = rememberFlag;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public Long getCategoryId() {
        return categoryId;
    }

    @Override
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
