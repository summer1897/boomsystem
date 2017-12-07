package com.boom.rbac.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/7 下午9:40
 * @Description
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = -7191015071775255718L;

    /**主键*/
    private String id;
    /**名称*/
    private String name;
    /**资源类型（有菜单和按钮）*/
    private String resourceType;
    /**资源路径，如果为空，则为顶级菜单*/
    private String url;
    /**权限字符串,如menu,role:*,button,role:create,role:delete,role:update,role:view*/
    private String permission;
    /**父编号*/
    private String parentId;
    /**父编号列表*/
    private String parentIds;
    /**是否禁用，0表示禁用，1启用*/
    private Byte available = 0;

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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }
}
