package com.cemware.dodo.domain;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskId")
    private int task_id;

    private String title;
    private String description;
    private String status;

    protected Task() {}

    public int getTask_id() {
        return task_id;
    }
    public void updateTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTitle() {
        return title;
    }
    public void updateTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void updateDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }
    public void updateStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    // Task N : 1 User
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
