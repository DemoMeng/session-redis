package com.mqz.model;

import java.io.Serializable;

/**
 * @author mqz
 * @description
 * @since 2020/6/24
 */
public class User implements Serializable {

    private static final long serialVersionUID = 5371122698420380226L;

    private String userName;

    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
