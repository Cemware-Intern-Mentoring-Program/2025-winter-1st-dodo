package com.cemware.dodo.dto.task;

import com.cemware.dodo.domain.Group;
import com.cemware.dodo.domain.Task;
import com.cemware.dodo.dto.group.GroupDto;
import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskStatus;
    private int groupId;

    public static TaskDto from(Task task) {
        return TaskDto.builder()
                .taskId(task.getTaskId())
                .taskTitle(task.getTaskTitle())
                .taskDescription(task.getTaskDescription())
                .taskStatus(task.getTaskStatus())
                .build();
    }

}
