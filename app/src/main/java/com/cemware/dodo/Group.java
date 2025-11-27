package com.cemware.dodo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int group_id;

    private String name;

    public Group() {}

    public int getGroup_id() {
        return group_id;
    }
    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "group")
    private List<Task> tasks;
}
