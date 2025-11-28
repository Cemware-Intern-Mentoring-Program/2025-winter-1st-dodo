package com.cemware.dodo.domain;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int user_id;

    @Column(name = "userEmail")
    private String user_email;

    private String password;

    protected User() {}

    public int getId() {
        return user_id;
    }
    public void updateId(int id) {
        this.user_id = id;
    }

    public String getUser_email() {
        return user_email;
    }
    public void updateUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }
    public void updatePassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user")
    private List<Group> groups;


    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

}