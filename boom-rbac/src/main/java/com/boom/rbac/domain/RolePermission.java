package com.boom.rbac.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/7 下午10:14
 * @Description 角色权限关系实体对象
 */
public class RolePermission implements Serializable {
    private static final long serialVersionUID = -8159790746838918L;

    private String roleId;
    private String permissonId;

    public RolePermission() {
    }

    public RolePermission(String roleId, String permissonId) {
        this.roleId = roleId;
        this.permissonId = permissonId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissonId() {
        return permissonId;
    }

    public void setPermissonId(String permissonId) {
        this.permissonId = permissonId;
    }
}
