package com.springBootTutorial.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable {

    @Id
    private String id;
    private String name;

    public User() { }

    public User(String name) {
        this.id = getRandomId();
        this.name = name;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

    private String getRandomId() {
        Integer id = new Random().nextInt(10000);
        return id.toString();
    }

}
