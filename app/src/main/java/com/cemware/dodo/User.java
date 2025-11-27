package com.cemware.dodo;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String user_email;
    private String password;

    public User() {}

    public int getId() {
        return user_id;
    }
    public void setId(int id) {
        this.user_id = id;
    }

    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user")
    private List<Group> groups;


    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

}