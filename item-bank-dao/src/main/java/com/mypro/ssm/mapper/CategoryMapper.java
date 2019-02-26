package com.mypro.ssm.mapper;

import com.mypro.ssm.po.Category;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.base.insert.InsertMapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface CategoryMapper extends Mapper<Category>,InsertUseGeneratedKeysMapper<Category> {

    void deleteAll();

    Integer addUseKey(Category category);
}
