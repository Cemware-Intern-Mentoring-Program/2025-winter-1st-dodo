package com.cemware.dodo.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupId")
    private int group_id;

    private String name;

    protected Group() {}

    public int getGroup_id() {
        return group_id;
    }
    public void updateGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }
    public void updateName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "group")
    private List<Task> tasks;
}
