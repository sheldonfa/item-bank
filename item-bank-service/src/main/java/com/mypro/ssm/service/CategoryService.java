package com.mypro.ssm.service;

import com.mypro.ssm.BusinessException;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.vo.TreeNode;

import java.util.List;

public interface CategoryService {

    public List<Category> findRoot();

    /**
     * 返回完整树结构目录
     * @return
     */
    List<TreeNode> tree();

    Integer add(Category category);

    Integer del(Long id) throws BusinessException;
}
