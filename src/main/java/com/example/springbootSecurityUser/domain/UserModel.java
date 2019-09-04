package com.example.springbootSecurityUser.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:
 * Description:
 * date: 2019/8/22 0022 15:50
 *
 * @author SS
 * @since JDK 1.8
 */

public class UserModel implements Serializable {

    private Integer id;
    private String userName;
    private String passWord;
    private String role;
    private String faceImage;
    private String remark;

    public UserModel() {
    }

    public UserModel(Integer id, String userName, String passWord, String role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
