package com.cemware.dodo.controller;

import com.cemware.dodo.dto.task.*;
import com.cemware.dodo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    /*
Task
할 일 만들기 (1건)
할 일 수정하기 (1건)
할 일 삭제하기 (1건)
할 일 읽기 (1건)
*/

    private final TaskService taskService;

    //task 생성하기
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(request)); //서비스에 createTask
    }

    //task 불러오기
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable int id) {
        return ResponseEntity.ok().body(taskService.getTask(id)); //서비스에 getTask
    }

    //task 수정
    @PatchMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable int id, @RequestBody TaskUpdateRequest request) {
        return ResponseEntity.ok().body(taskService.updateTask(id, request)); //서비스에 updateTask
    }

    //task 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id); //서비스에 deleteTask
        return ResponseEntity.ok().body(null);
    }

}

