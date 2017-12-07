package com.boom.rbac.domain;

import java.io.Serializable;

/**
 * Created by summer on 2017/12/7.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 5811977737256559537L;

    /**用户唯一编号*/
    private String id;
    /**用户账号*/
    private String userName;
     /**用户昵称或姓名*/
    private String nickName;
    /**用户密码*/
    private String password;
    /**加密密码的盐*/
    private String salt;
    /**用户状态，0：创建未认证（比如，邮箱注册，没有激活），1：正常状态，2：用户被锁定*/
    private Byte state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 密码盐（用于对明文密码进行加密）
     * @return
     */
    public String getCredentialSalt() {
        return this.userName + this.salt;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
