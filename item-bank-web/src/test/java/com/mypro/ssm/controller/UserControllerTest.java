package com.mypro.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.ssm.po.User;
import com.mypro.ssm.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/applicationContext-*"})
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void pageList() {
        PageInfo<User> userRoles = userService.findUserRoles(1, 10);
        System.out.println(userRoles);
    }
}