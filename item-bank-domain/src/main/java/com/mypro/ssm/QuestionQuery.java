package com.mypro.ssm;

import com.mypro.ssm.po.Question;

public class QuestionQuery extends Question {

    private Boolean rememberFlag;

    public Boolean getRememberFlag() {
        return rememberFlag;
    }

    public void setRememberFlag(Boolean rememberFlag) {
        this.rememberFlag = rememberFlag;
    }
}
