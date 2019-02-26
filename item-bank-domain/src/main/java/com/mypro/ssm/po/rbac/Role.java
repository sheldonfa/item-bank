package com.mypro.ssm.po.rbac;


import java.io.Serializable;
import java.util.List;

/**
 * POJO:Role
 *
 * @author fangxin
 * @date 2019-2-25
 */
public class Role implements Serializable {

    private Long id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    //页面字符，是否选中
    private Integer checked;

    public Role() {
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Role [" + "id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
    }
}
