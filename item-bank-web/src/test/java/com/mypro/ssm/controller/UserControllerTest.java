package com.mypro.ssm.controller;

import com.mypro.ssm.po.User;
import com.mypro.ssm.service.UserService;
import com.ninja_squad.dbsetup.DbSetupTracker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/applicationContext-*"})
public class UserControllerTest {

    private static DbSetupTracker dbSetupTracker = new DbSetupTracker();

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void pageList() {
        List<User> u1 = userService.findUserRoles();
        User u2 = userService.findUserRoles(1L);
        Assert.notEmpty(u1.get(0).getRoles(), "roles不能为空");
        Assert.notEmpty(u2.getRoles(), "roles不能为空");
        Assert.notEmpty(u2.getRoles().get(0).getPermissions(), "permission不能为空");
    }

    @Test
    @Rollback
    public void test2() {
        userService.updateUserRole(1L, new Long[]{1L, 2L});
    }
}