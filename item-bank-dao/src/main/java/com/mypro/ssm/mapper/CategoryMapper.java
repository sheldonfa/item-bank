package com.mypro.ssm.mapper;

import com.mypro.ssm.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {

    /**
     * 添加
     *
     * @author fangxin
     * @date 2019-2-26
     */
    Integer insert(Category category);

    /**
     * 选择性添加
     *
     * @author fangxin
     * @date 2019-2-26
     */
    Integer insertSelective(Category category);

    /**
     * 根据主键删除
     *
     * @author fangxin
     * @date 2019-2-26
     */
    Integer deleteById(Long id);

    /**
     * 根据主键数组删除
     *
     * @author fangxin
     * @date 2019-2-26
     */
    Integer deleteByIds(Long[] ids);

    /**
     * 条件删除
     *
     * @author fangxin
     * @date 2019-2-26
     */
    Integer delete(Category category);

    /**
     * 更新
     *
     * @author fangxin
     * @date 2019-2-26
     */
    Integer update(Category category);

    /**
     * 查询
     *
     * @author fangxin
     * @date 2019-2-26
     */
    List<Category> find(Category category);

    /**
     * 查询全部
     *
     * @author fangxin
     * @date 2019-2-26
     */
    List<Category> findAll();

    /**
     * 查询数量
     *
     * @author fangxin
     * @date 2019-2-26
     */
    Long findCount(Category category);

    /**
     * 根据主键查询
     *
     * @author fangxin
     * @date 2019-2-26
     */
    Category findById(Long id);

    void deleteAll();

    Integer addUseKey(Category category);
}
