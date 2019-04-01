package com.mypro.ssm.service;

import com.mypro.exception.BusinessException;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.vo.TreeNode;

import java.util.List;

public interface CategoryService {

    /**
     * 添加
     * @author fangxin
     * @date 2019-2-26
     */
    Integer insert(Category category);

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-26
     */
    Integer insertSelective(Category category);

    /**
     * 根据主键删除
     * @author fangxin
     * @date 2019-2-26
     */
    Integer deleteById(Long id);

    /**
     * 根据主键数组删除
     * @author fangxin
     * @date 2019-2-26
     */
    Integer deleteByIds(Long[] ids);

    /**
     * 条件删除
     * @author fangxin
     * @date 2019-2-26
     */
    Integer delete(Category category);

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-26
     */
    Integer update(Category category);

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-26
     */
    List<Category> find(Category category);

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-26
     */
    List<Category> findAll();

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-26
     */
    Long findCount(Category category);

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-26
     */
    Category findById(Long id);

    public List<Category> findRoot();

    /**
     * 返回完整树结构目录
     * @return
     */
    List<TreeNode> tree();

    public Integer add(Category category);

    Integer del(Long id) throws BusinessException;

    List<Category> findChildren(Long id);
}
