package com.cemware.dodo.service;

import com.cemware.dodo.domain.Task;
import com.cemware.dodo.dto.task.*;
import com.cemware.dodo.dto.user.UserDto;
import com.cemware.dodo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    // task 생성
    public TaskDto createTask(TaskCreateRequest request) {
        Task task = Task.builder()
                .taskId(request.getTaskId())
                .taskTitle(request.getTaskTitle())
                .taskDescription(request.getTaskDescription())
                .taskStatus(request.getTaskStatus())
                .build();

        return TaskDto.from(taskRepository.save(task));
    }

    // task 조회(하위 할 일)
    public TaskDto getTask(int taskId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("할 일 조회 오류"));

        return TaskDto.from(task);
    }

    // task 수정
    public TaskDto updateTask(int id, TaskUpdateRequest request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("할 일 수정 오류"));

        if (request.getTaskTitle() != null) task.updateTaskTitle(request.getTaskTitle());
        if (request.getTaskDescription() != null) task.updateTaskDescription(request.getTaskDescription());
        if (request.getTaskStatus() != null) task.updateTaskStatus(request.getTaskStatus());

        return TaskDto.from(taskRepository.save(task));

    }

    // task 삭제
    public void deleteTask(int id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("할 일 삭제 오류"));

        taskRepository.delete(task);
    }

}

