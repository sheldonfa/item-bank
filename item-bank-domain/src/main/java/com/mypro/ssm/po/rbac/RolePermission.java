package com.mypro.ssm.po.rbac;


/**
 * POJO:RolePermission
 * 
 * @author fangxin
 * @date 2019-2-25
 */
public class RolePermission implements Serializable {
	
	private Integer	roleId;		
	private Integer	permissionId;		

	// Constructor
	public RolePermission() {
	}
	
	/**
	 * full Constructor
	 */
	public RolePermission(Integer roleId, Integer permissionId) {
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为RolePermission可以实现连缀设置属性
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return "RolePermission [" + "roleId=" + roleId + ", permissionId=" + permissionId +  "]";
	}
}
