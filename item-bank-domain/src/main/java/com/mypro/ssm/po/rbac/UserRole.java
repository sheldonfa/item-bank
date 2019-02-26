package com.mypro.ssm.po.rbac;

import java.io.Serializable;

/**
 * POJO:UserRole
 *
 * @author fangxin
 * @date 2019-2-25
 */
public class UserRole implements Serializable {

    private Integer userId;
    private Integer roleId;

    // Constructor
    public UserRole() {
    }

    /**
     * full Constructor
     */
    public UserRole(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    // getter && setter
    // 在setter方法最后加上"return this;"并把返回参数改为UserRole可以实现连缀设置属性
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole [" + "userId=" + userId + ", roleId=" + roleId + "]";
    }
}
