package com.cemware.dodo.dto.task;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //전체 필드 생성자
public class TaskCreateRequest {

    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskStatus;
    private int groupId;

}
