package com.mypro.ssm.po.rbac;


import java.io.Serializable;

/**
 * POJO:Permission
 *
 * @author fangxin
 * @date 2019-2-25
 */
public class Permission implements Serializable {

    private Long id;
    private String permissionName;
    private String url;

    private Integer checked;

    // Constructor
    public Permission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Permission [" + "id=" + id + ", permissionName=" + permissionName + ", url=" + url + "]";
    }
}
