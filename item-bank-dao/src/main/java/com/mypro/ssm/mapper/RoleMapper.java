package com.mypro.ssm.mapper;

import com.mypro.ssm.po.rbac.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper Interface:Role
 *
 * @author fangxin
 * @date 2019-2-25
 */

public interface RoleMapper {
    /**
     * 添加
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insert(Role role);

    /**
     * 选择性添加
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insertSelective(Role role);

    /**
     * 根据主键删除
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Integer deleteById(Long id);

    /**
     * 根据主键数组删除
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Integer deleteByIds(Long[] ids);

    /**
     * 条件删除
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Integer delete(Role role);

    /**
     * 更新
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Integer update(Role role);

    /**
     * 查询
     *
     * @author fangxin
     * @date 2019-2-25
     */
    List<Role> find(Role role);

    /**
     * 查询全部
     *
     * @author fangxin
     * @date 2019-2-25
     */
    List<Role> findAll();

    /**
     * 查询数量
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Long findCount(Role role);

    /**
     * 根据主键查询
     *
     * @author fangxin
     * @date 2019-2-25
     */
    List<Role> findById(Long id);

    void deleteRolePermission(@Param("roleId") Long roleId);

    void insertRolePermission(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    Role findRolePermissions(Long id);
}