package com.mypro.ssm.service.impl;

import com.mypro.ssm.mapper.UserRoleMapper;
import com.mypro.ssm.po.rbac.UserRole;
import com.mypro.ssm.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Service Implementation:UserRole
 * @author fangxin
 * @date 2019-2-25
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    /**
     * 添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insert(UserRole userRole){
        return userRoleMapper.insert(userRole);
    }

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insertSelective(UserRole userRole){
        return userRoleMapper.insertSelective(userRole);
    }

    /**
     * 根据主键删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteById(Long id){
        return userRoleMapper.deleteById(id);
    }

    /**
     * 根据主键数组删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteByIds(Long[] ids){
        return userRoleMapper.deleteByIds(ids);
    }

    /**
     * 条件删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer delete(UserRole userRole){
        return userRoleMapper.delete(userRole);
    }

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer update(UserRole userRole){
        return userRoleMapper.update(userRole);
    }

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
	public List<UserRole> find(UserRole userRole){
        return userRoleMapper.find(userRole);
    }

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<UserRole> findAll(){
        return userRoleMapper.findAll();
    }

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Long findCount(UserRole userRole){
        return userRoleMapper.findCount(userRole);
    }

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<UserRole> findById(Long id){
        return userRoleMapper.findById(id);
    }
}
