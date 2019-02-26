package com.mypro.ssm.service.impl;

import com.mypro.ssm.mapper.UserMapper;
import com.mypro.ssm.po.User;
import com.mypro.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.mypro.ssm.service.impl.UserServiceImpl;
import java.util.List;

/**
 * Service Implementation:User
 * @author fangxin
 * @date 2019-2-25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insert(User user){
        return userMapper.insert(user);
    }

    /**
     * 选择性添加
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer insertSelective(User user){
        return userMapper.insertSelective(user);
    }

    /**
     * 根据主键删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteById(Long id){
        return userMapper.deleteById(id);
    }

    /**
     * 根据主键数组删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer deleteByIds(Long[] ids){
        return userMapper.deleteByIds(ids);
    }

    /**
     * 条件删除
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer delete(User user){
        return userMapper.delete(user);
    }

    /**
     * 更新
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Integer update(User user){
        return userMapper.update(user);
    }

    /**
     * 查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
	public List<User> find(User user){
        return userMapper.find(user);
    }

    /**
     * 查询全部
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }

    /**
     * 查询数量
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public Long findCount(User user){
        return userMapper.findCount(user);
    }

    /**
     * 根据主键查询
     * @author fangxin
     * @date 2019-2-25
     */
    @Override
    public List<User> findById(Long id){
        return userMapper.findById(id);
    }
}
