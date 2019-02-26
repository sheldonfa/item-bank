package com.mypro.ssm.service;

import com.mypro.ssm.po.rbac.Role;
import com.mypro.ssm.service.RoleService;
import java.util.List;

/**
 * Service Interface:Role
 * @author fangxin
 * @date 2019-2-25
 */
public interface RoleService{

    /**
     * 添加
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insert(Role role);

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-25
     */
    Integer insertSelective(Role role);

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
    Integer delete(Role role);

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-25
     */
    Integer update(Role role);

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-25
     */
	List<Role> find(Role role);

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-25
     */
    List<Role> findAll();

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-25
     */
    Long findCount(Role role);

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-25
     */
    List<Role> findById(Long id);
}