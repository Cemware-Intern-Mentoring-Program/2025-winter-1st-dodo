package com.cemware.dodo.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "todo_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private int taskId;

    private String taskTitle;
    private String taskDescription;
    private String taskStatus;

    protected Task() {}

    public void updateTaskId(int taskId) {
        this.taskId = taskId;
    }
    public void updateTaskTitle(String title) {
        this.taskTitle = title;
    }
    public void updateTaskDescription(String description) {
        this.taskDescription = description;
    }
    public void updateTaskStatus(String status) {
        this.taskStatus = status;
    }

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    // Task N : 1 User
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
