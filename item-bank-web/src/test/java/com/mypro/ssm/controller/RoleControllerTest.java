package com.mypro.ssm.controller;

import com.mypro.ssm.po.rbac.Role;
import com.mypro.ssm.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.notEmpty;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/applicationContext-*"})
@Transactional
public class RoleControllerTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testFindRolePermission() {
        Role role = roleService.findRolePermissions(1L);
        notNull(role, "role不能为null");
        notEmpty(role.getPermissions(), "permission不能为空");
        notNull(role.getPermissions().get(0).getId(),"id不能为null");
    }

    @Test
    @Rollback
    public void testUpdateRolePermission() {
        roleService.updateRolePermission(1L, new Long[]{1L, 2L, 3L, 4L});
        Role role = roleService.findRolePermissions(1L);
        assertEquals(4, role.getPermissions().size());
    }
}
