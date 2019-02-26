package com.mypro.ssm.service.impl;

import com.mypro.ssm.service.RolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Service Implementation:RolePermission
 * @author fangxin
 * @date 2019-2-25
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;


    /**
     * 添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insert(RolePermission rolePermission){
        return rolePermissionMapper.insert(rolePermission);
    }

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insertSelective(RolePermission rolePermission){
        return rolePermissionMapper.insertSelective(rolePermission);
    }

    /**
     * 根据主键删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteById(Long id){
        return rolePermissionMapper.deleteById(id);
    }

    /**
     * 根据主键数组删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteByIds(Long[] ids){
        return rolePermissionMapper.deleteByIds(ids);
    }

    /**
     * 条件删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer delete(RolePermission rolePermission){
        return rolePermissionMapper.delete(rolePermission);
    }

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer update(RolePermission rolePermission){
        return rolePermissionMapper.update(rolePermission);
    }

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
	public List<RolePermission> find(RolePermission rolePermission){
        return rolePermissionMapper.find(rolePermission);
    }

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<RolePermission> findAll(){
        return rolePermissionMapper.findAll();
    }

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Long findCount(RolePermission rolePermission){
        return rolePermissionMapper.findCount(rolePermission);
    }

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<RolePermission> findById(Long id){
        return rolePermissionMapper.findById(id);
    }
}
