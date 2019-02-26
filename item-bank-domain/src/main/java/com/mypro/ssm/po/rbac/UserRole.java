package com.mypro.ssm.po.rbac;

import java.io.Serializable;

/**
 * POJO:UserRole
 *
 * @author fangxin
 * @date 2019-2-25
 */
public class UserRole implements Serializable {

    private Long userId;
    private Long roleId;

    // Constructor
    public UserRole() {
    }

    /**
     * full Constructor
     */
    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole [" + "userId=" + userId + ", roleId=" + roleId + "]";
    }
}
