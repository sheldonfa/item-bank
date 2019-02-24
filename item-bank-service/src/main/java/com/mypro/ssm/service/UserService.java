package com.mypro.ssm.service;

import com.github.pagehelper.PageInfo;
import com.mypro.ssm.po.User;

public interface UserService {

    PageInfo<User> findAll(Integer pageNum, Integer pageSize);

}
