package com.mypro.ssm.service;

import com.github.pagehelper.PageInfo;
import com.mypro.ssm.po.User;
import com.mypro.ssm.service.UserService;
import java.util.List;

/**
 * Service Interface:User
 * @author fangxin
 * @date 2019-2-25
 */
public interface UserService{

    /**
     * 添加
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insert(User user);

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insertSelective(User user);

    /**
     * 根据主键删除
     * @author fangxin
     * @date 2019-2-25
     */
    Integer deleteById(Long id);

    /**
     * 根据主键数组删除
     * @author fangxin
     * @date 2019-2-25
     */
    Integer deleteByIds(Long[] ids);

    /**
     * 条件删除
     * @author fangxin
     * @date 2019-2-25
     */
    Integer delete(User user);

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-25
     */
    Integer update(User user);

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-25
     */
	List<User> find(User user);

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-25
     */
    List<User> findAll();

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-25
     */
    Long findCount(User user);

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-25
     */
    List<User> findById(Long id);

    /**
     * 显示
     */
    List<User> findUserRoles();

    /**
     * 显示
     */
    User findUserRoles(Long id);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<User> page(Integer pageNum, Integer pageSize);

    void updateUserRole(Long userId, Long[] ids);
}