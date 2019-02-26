package com.mypro.ssm.service;

import com.mypro.ssm.po.rbac.RolePermission;
import com.mypro.ssm.service.RolePermissionService;
import java.util.List;

/**
 * Service Interface:RolePermission
 * @author fangxin
 * @date 2019-2-25
 */
public interface RolePermissionService{

    /**
     * 添加
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insert(RolePermission rolePermission);

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insertSelective(RolePermission rolePermission);

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
    Integer delete(RolePermission rolePermission);

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-25
     */
    Integer update(RolePermission rolePermission);

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-25
     */
	List<RolePermission> find(RolePermission rolePermission);

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-25
     */
    List<RolePermission> findAll();

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-25
     */
    Long findCount(RolePermission rolePermission);

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-25
     */
    List<RolePermission> findById(Long id);
}