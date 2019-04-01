package com.mypro.ssm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mypro.exception.BusinessException;
import com.mypro.ssm.common.CodeMsg;
import com.mypro.ssm.mapper.CategoryMapper;
import com.mypro.ssm.mapper.QuestionMapper;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.service.CategoryService;
import com.mypro.util.JSONUtil;
import com.mypro.util.TreeBuilder;
import com.mypro.ssm.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 添加
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public Integer insert(Category category){
        return categoryMapper.insert(category);
    }

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public Integer insertSelective(Category category){
        return categoryMapper.insertSelective(category);
    }

    /**
     * 根据主键删除
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public Integer deleteById(Long id){
        return categoryMapper.deleteById(id);
    }

    /**
     * 根据主键数组删除
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public Integer deleteByIds(Long[] ids){
        return categoryMapper.deleteByIds(ids);
    }

    /**
     * 条件删除
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public Integer delete(Category category){
        return categoryMapper.delete(category);
    }

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public Integer update(Category category){
        return categoryMapper.update(category);
    }

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public List<Category> find(Category category){
        return categoryMapper.find(category);
    }

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public List<Category> findAll(){
        return categoryMapper.findAll();
    }

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public Long findCount(Category category){
        return categoryMapper.findCount(category);
    }

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-26
     */
    @Override
    public Category findById(Long id){
        return categoryMapper.findById(id);
    }

    @Override
    public List<Category> findRoot() {
        return findByParentId(0L);
    }

    @Override
    public List<TreeNode> tree() {
        ArrayList<TreeNode> trees = new ArrayList<>();
        List<Category> all = categoryMapper.findAll();
        for (Category c : all) {
            TreeNode treeNode = new TreeNode();
            treeNode.setCode(c.getId());
            treeNode.setParentCode(c.getParentId());
            treeNode.setName(c.getName());
            List<String> tags = new ArrayList<>();
            Map<String, String> info = new HashMap<>();
            info.put("id", c.getId().toString());
            try {
                tags.add(JSONUtil.obj2Stirng(info));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
            trees.add(treeNode);
        }
        return TreeBuilder.buildByRecursive(trees);
    }

    @Override
    public Integer add(Category category) {
        return categoryMapper.insertSelective(category);
    }

    @Override
    public Integer del(Long id) throws BusinessException {
        Question param = new Question();
        param.setCategoryId(id);
        // 判断是否是挂载目录
        Category c = categoryMapper.findById(id);
        List<Question> questions = questionMapper.find(param);
        // 目录下没有任何题目了
        if (questions.size() == 0) {
            Category para = new Category();
            para.setId(id);
            return categoryMapper.delete(para);
        } else {
            throw new BusinessException(CodeMsg.NOT_EMPTY_CATEGORY_EXCEPTION);
        }

    }

    @Override
    public List<Category> findChildren(Long id) {
        Category category = new Category();
        category.setParentId(id);

        return categoryMapper.find(category);
    }

    private List<Category> findByParentId(Long parentId) {
        Category c = new Category();
        c.setParentId(parentId);
        return categoryMapper.find(c);
    }
}
