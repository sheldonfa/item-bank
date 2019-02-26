package com.mypro.ssm.po.rbac;


/**
 * POJO:Role
 * 
 * @author fangxin
 * @date 2019-2-25
 */
public class Role implements Serializable {
	
	private Integer	id;		
	private String	roleName;		
	private String	roleDesc;		

	// Constructor
	public Role() {
	}
	
	/**
	 * full Constructor
	 */
	public Role(Integer id, String roleName, String roleDesc) {
		this.id = id;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Role可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "Role [" + "id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc +  "]";
	}
}
