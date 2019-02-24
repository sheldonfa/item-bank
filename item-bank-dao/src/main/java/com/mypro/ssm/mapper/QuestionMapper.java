package com.mypro.ssm.mapper;

import com.mypro.ssm.po.Question;
import tk.mybatis.mapper.common.Mapper;

public interface QuestionMapper extends Mapper<Question> {
    int deleteAll();
}
