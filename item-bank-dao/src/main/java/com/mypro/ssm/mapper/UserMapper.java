package com.mypro.ssm.mapper;

import com.mypro.ssm.mapper.UserMapper;
import com.mypro.ssm.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper Interface:User
 * @author fangxin
 * @date 2019-2-25
 */

public interface UserMapper{
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
     * 关联查询用户角色
     * @return
     */
    List<User> findUserRoles();

    /**
     * 根据id关联查询
     * @param id
     * @return
     */
    User findUserRolesPermissionsById(Long id);

    void deleteUserAndRole(@Param("userId") Long userId);

    void insertUserAndRole(@Param("userId") Long userId,@Param("roleId") Long roleId);
}