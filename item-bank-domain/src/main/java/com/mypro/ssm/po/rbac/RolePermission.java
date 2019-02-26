package com.mypro.ssm.po.rbac;


import java.io.Serializable;

/**
 * POJO:RolePermission
 * 
 * @author fangxin
 * @date 2019-2-25
 */
public class RolePermission implements Serializable {
	
	private Long	roleId;
	private Long	permissionId;

	// Constructor
	public RolePermission() {
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return "RolePermission{" +
				"roleId=" + roleId +
				", permissionId=" + permissionId +
				'}';
	}
}
