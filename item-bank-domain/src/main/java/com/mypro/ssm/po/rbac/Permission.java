package com.mypro.ssm.po.rbac;


/**
 * POJO:Permission
 * 
 * @author fangxin
 * @date 2019-2-25
 */
public class Permission implements Serializable {
	
	private Integer	id;		
	private String	permissionName;		 /* 权限名称 */ 
	private String	url;		 /* 资源路径 */ 

	// Constructor
	public Permission() {
	}
	
	/**
	 * full Constructor
	 */
	public Permission(Integer id, String permissionName, String url) {
		this.id = id;
		this.permissionName = permissionName;
		this.url = url;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Permission可以实现连缀设置属性
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Permission [" + "id=" + id + ", permissionName=" + permissionName + ", url=" + url +  "]";
	}
}
