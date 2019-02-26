package com.mypro.ssm.service;

import com.github.pagehelper.PageInfo;
import com.mypro.ssm.po.rbac.Permission;
import com.mypro.ssm.po.rbac.Role;
import com.mypro.ssm.service.PermissionService;

import java.util.List;

/**
 * Service Interface:Permission
 *
 * @author fangxin
 * @date 2019-2-25
 */
public interface PermissionService {

    /**
     * 添加
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insert(Permission permission);

    /**
     * 选择性添加
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insertSelective(Permission permission);

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
    Integer delete(Permission permission);

    /**
     * 更新
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Integer update(Permission permission);

    /**
     * 查询
     *
     * @author fangxin
     * @date 2019-2-25
     */
    List<Permission> find(Permission permission);

    /**
     * 查询全部
     *
     * @author fangxin
     * @date 2019-2-25
     */
    List<Permission> findAll();

    /**
     * 查询数量
     *
     * @author fangxin
     * @date 2019-2-25
     */
    Long findCount(Permission permission);

    /**
     * 根据主键查询
     *
     * @author fangxin
     * @date 2019-2-25
     */
    List<Permission> findById(Long id);

    PageInfo<Permission> page(Integer pageNum, Integer pageSize);
}