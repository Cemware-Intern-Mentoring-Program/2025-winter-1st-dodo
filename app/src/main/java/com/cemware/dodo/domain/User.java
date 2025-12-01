package com.cemware.dodo.domain;


import jakarta.persistence.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Builder
public class User {

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

}