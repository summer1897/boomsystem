package com.boom.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Intellij IDEA
 * @Project file-manager
 * @Author summer
 * @Date 2018/1/9
 * @Time 下午8:05
 * @Description 文件资源实体类
 */
public class FileResource implements Serializable {
    private static final long serialVersionUID = -4048505407902232240L;

    /**文件资源唯一表示ID*/
    private Integer id;
    /**文件原名称*/
    private String originName;
    /**文件新名称*/
    private String newName;
    /**文件扩展名*/
    private String extension;
    /**文件类型*/
    private String type;
    /**文件大小*/
    private Long size;
    /**文件最近一次修改时间*/
    private Date modifyDate;
    /**文件上传时间*/
    private Date uploadDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
