package com.cemware.dodo.domain;


import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Getter
@Builder
public class User extends UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_email")
    private String userEmail;

    private String password;

    protected User() {}

    public void updateId(int id) {
        this.userId = id;
    } //hmm
    public void updateUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public void updatePassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Group> groups;


    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Task> tasks;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

    }

    @Override
    public String getUsername() {
        return this.userEmail;
    }
}