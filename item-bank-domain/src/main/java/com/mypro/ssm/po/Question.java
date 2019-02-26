package com.mypro.ssm.po;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Question {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private Long categoryId;
    private String content;
    private Integer stage;
    private Date lastReviewTime;

    private Date gmtCreate;
    private Date gmtModified;
    private Boolean isDeleted;

    public Question() {
    }

    public Question(Long categoryId, String content, Integer stage, Date lastReviewTime) {
        this.categoryId = categoryId;
        this.content = content;
        this.stage = stage;
        this.lastReviewTime = lastReviewTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long type) {
        this.categoryId = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Date getLastReviewTime() {
        return lastReviewTime;
    }

    public void setLastReviewTime(Date lastReviewTime) {
        this.lastReviewTime = lastReviewTime;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", content='" + content + '\'' +
                ", stage=" + stage +
                ", lastReviewTime=" + lastReviewTime +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
