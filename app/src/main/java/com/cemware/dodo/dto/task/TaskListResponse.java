package com.cemware.dodo.dto.task;

import com.cemware.dodo.dto.task.*;
import com.cemware.dodo.domain.Task;
import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class TaskListResponse {

    private List<TaskDto> tasks;

    public static TaskListResponse from(List<TaskDto> tasks) {
        return new TaskListResponse(tasks);
    }
}
