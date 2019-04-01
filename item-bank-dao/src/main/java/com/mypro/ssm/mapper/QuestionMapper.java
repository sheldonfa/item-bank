package com.mypro.ssm.mapper;

import com.mypro.ssm.po.Question;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface QuestionMapper{

    /**
     * 添加
     * @author fangxin
     * @date 2019-2-27
     */
    Integer insert(Question question);

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-27
     */
    Integer insertSelective(Question question);

    /**
     * 根据主键删除
     * @author fangxin
     * @date 2019-2-27
     */
    Integer deleteById(@Param("id") Long id);

    /**
     * 根据主键数组删除
     * @author fangxin
     * @date 2019-2-27
     */
    Integer deleteByIds(@Param("ids") Long[] ids);

    /**
     * 条件删除
     * @author fangxin
     * @date 2019-2-27
     */
    Integer delete(Question question);

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-27
     */
    Integer update(Question question);

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-27
     */
    List<Question> find(Question question);

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-27
     */
    List<Question> findAll();

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-27
     */
    Long findCount(Question question);

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-27
     */
    Question findById(Long id);

    List<Question> findByCategory(Long categoryId);
}
