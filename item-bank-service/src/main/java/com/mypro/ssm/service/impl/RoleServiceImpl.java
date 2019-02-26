package com.mypro.ssm.service.impl;

import com.mypro.ssm.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Service Implementation:Role
 * @author fangxin
 * @date 2019-2-25
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    /**
     * 添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insert(Role role){
        return roleMapper.insert(role);
    }

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insertSelective(Role role){
        return roleMapper.insertSelective(role);
    }

    /**
     * 根据主键删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteById(Long id){
        return roleMapper.deleteById(id);
    }

    /**
     * 根据主键数组删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteByIds(Long[] ids){
        return roleMapper.deleteByIds(ids);
    }

    /**
     * 条件删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer delete(Role role){
        return roleMapper.delete(role);
    }

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer update(Role role){
        return roleMapper.update(role);
    }

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
	public List<Role> find(Role role){
        return roleMapper.find(role);
    }

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<Role> findAll(){
        return roleMapper.findAll();
    }

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Long findCount(Role role){
        return roleMapper.findCount(role);
    }

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<Role> findById(Long id){
        return roleMapper.findById(id);
    }
}
