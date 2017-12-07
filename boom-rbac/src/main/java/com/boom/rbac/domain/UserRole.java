package com.boom.rbac.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/7 下午10:12
 * @Description 用户角色关系实体对象
 */
public class UserRole implements Serializable{
    private static final long serialVersionUID = -2450084104823370600L;
    private String userId;
    private String roleId;

    public UserRole() {
    }

    public UserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
