package com.boom.rbac.domain;

import java.io.Serializable;

/**
 * Created by yangyang on 2017/12/7.
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 565651037360395463L;

    /**角色唯一编号*/
    private String id;
    /**角色名*/
    private String role;
    /**角色描述*/
    private String description;
    /**标识角色是否可用，0：不可用，1：可用*/
    private Byte available = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
