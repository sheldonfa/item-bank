package com.mypro.ssm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mypro.ssm.BusinessException;
import com.mypro.ssm.common.CodeMsg;
import com.mypro.ssm.mapper.CategoryMapper;
import com.mypro.ssm.mapper.QuestionMapper;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.service.CategoryService;
import com.mypro.ssm.service.QuestionService;
import com.mypro.ssm.util.JSONUtil;
import com.mypro.ssm.util.TreeBuilder;
import com.mypro.ssm.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Category> findRoot() {
        return findByParentId(0L);
    }

    @Override
    public List<TreeNode> tree() {
        ArrayList<TreeNode> trees = new ArrayList<>();
        List<Category> all = categoryMapper.selectAll();
        for (Category c : all) {
            TreeNode treeNode = new TreeNode();
            treeNode.setNodeId(c.getId());
            treeNode.setParentId(c.getParentId());
            treeNode.setText(c.getName());
            List<String> tags = new ArrayList<>();
            Map<String, String> info = new HashMap<>();
            info.put("id", c.getId().toString());
            try {
                tags.add(JSONUtil.obj2Stirng(info));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
            treeNode.setTags(tags);
            trees.add(treeNode);
        }
        return TreeBuilder.buildByRecursive(trees);
    }

    @Override
    public Integer add(Category category) {
        return categoryMapper.addUseKey(category);
    }

    @Override
    public Integer del(Long id) throws BusinessException {
        Question param = new Question();
        param.setCategoryId(id);
        // 判断是否是挂载目录
        Category c = categoryMapper.selectByPrimaryKey(id);
        List<Question> questions = questionMapper.select(param);
        // 目录下没有任何题目了
        if (questions.size() == 0) {
            Category para = new Category();
            para.setId(id);
            return categoryMapper.delete(para);
        } else {
            throw new BusinessException(CodeMsg.NOT_EMPTY_CATEGORY_EXCEPTION);
        }

    }

    private List<Category> findByParentId(Long parentId) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", parentId);
        return categoryMapper.selectByExample(example);
    }
}
