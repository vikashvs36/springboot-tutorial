package com.springBootTutorial.domain.vo;

public class UserVo {

    private String name;

    public UserVo() { }

    public UserVo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
