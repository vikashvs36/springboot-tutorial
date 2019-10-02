package com.springBootTutorial.domain.vo;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class UserVo {

    @NotNull(message = "Username shouldn't be blank.")
    @Column(name = "username", columnDefinition = "User Name")
    private String username;

    @NotNull(message = "Password shouldn't be blank")
    @Column(name = "password", columnDefinition = "User Password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}