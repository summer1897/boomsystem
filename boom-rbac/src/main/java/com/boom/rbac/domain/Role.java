package com.boom.rbac.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangyang on 2017/12/7.
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 565651037360395463L;

    /**角色唯一编号*/
    private String id;
    /**角色名*/
    private String name;
    /**角色描述*/
    private String description;
    /**标识角色是否可用，0：不可用，1：可用*/
    private Byte available = 0;

    /**角色所具有的资源*/
    List<Permission> permissions;

    /**角色对应的所有用户*/
    List<User> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
