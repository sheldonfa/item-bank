package com.mypro.ssm.service;

import com.mypro.ssm.po.rbac.UserRole;
import com.mypro.ssm.service.UserRoleService;
import java.util.List;

/**
 * Service Interface:UserRole
 * @author fangxin
 * @date 2019-2-25
 */
public interface UserRoleService{

    /**
     * 添加
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insert(UserRole userRole);

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insertSelective(UserRole userRole);

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
    Integer delete(UserRole userRole);

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-25
     */
    Integer update(UserRole userRole);

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-25
     */
	List<UserRole> find(UserRole userRole);

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-25
     */
    List<UserRole> findAll();

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-25
     */
    Long findCount(UserRole userRole);

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-25
     */
    List<UserRole> findById(Long id);
}