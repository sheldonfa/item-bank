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
