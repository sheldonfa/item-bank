package com.mypro.ssm.service.impl;

import com.mypro.ssm.mapper.CategoryMapper;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findRoot() {
        return findByParentId(0L);
    }

    private List<Category> findByParentId(Long parentId) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", parentId);
        return categoryMapper.selectByExample(example);
    }
}
