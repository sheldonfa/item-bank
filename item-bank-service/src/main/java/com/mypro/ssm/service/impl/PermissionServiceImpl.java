package com.mypro.ssm.service.impl;

import com.mypro.ssm.mapper.PermissionMapper;
import com.mypro.ssm.po.rbac.Permission;
import com.mypro.ssm.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Service Implementation:Permission
 * @author fangxin
 * @date 2019-2-25
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


    /**
     * 添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insert(Permission permission){
        return permissionMapper.insert(permission);
    }

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insertSelective(Permission permission){
        return permissionMapper.insertSelective(permission);
    }

    /**
     * 根据主键删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteById(Long id){
        return permissionMapper.deleteById(id);
    }

    /**
     * 根据主键数组删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteByIds(Long[] ids){
        return permissionMapper.deleteByIds(ids);
    }

    /**
     * 条件删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer delete(Permission permission){
        return permissionMapper.delete(permission);
    }

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer update(Permission permission){
        return permissionMapper.update(permission);
    }

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
	public List<Permission> find(Permission permission){
        return permissionMapper.find(permission);
    }

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<Permission> findAll(){
        return permissionMapper.findAll();
    }

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Long findCount(Permission permission){
        return permissionMapper.findCount(permission);
    }

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<Permission> findById(Long id){
        return permissionMapper.findById(id);
    }
}
