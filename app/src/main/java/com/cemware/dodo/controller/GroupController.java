package com.cemware.dodo.controller;

import com.cemware.dodo.config.CustomUserDetails;
import com.cemware.dodo.dto.task.TaskDto;
import com.cemware.dodo.dto.group.*;
import com.cemware.dodo.dto.task.TaskListResponse;
import com.cemware.dodo.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Group
그룹 생성하기 (1건)
그룹 이름 수정하기 (1건)
그룹 삭제하기 (1건, 하위 할 일 삭제)
그룹 불러오기 (하위 할 일 불러오기)*/

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    //그룹 생성하기
    /*@PostMapping
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(groupService.createGroup(request)); //서비스에 createGroup
    }*/
    @PostMapping
    public ResponseEntity<GroupDto> createGroup(
            @RequestBody GroupCreateRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(groupService.createGroup(request, userDetails.getUser()));
    }

    //group name 수정
    @PatchMapping("/{id}")
    public ResponseEntity<GroupDto> updateGroup(@PathVariable int id, @RequestBody GroupUpdateRequest request) {
        return ResponseEntity.ok().body(groupService.updateGroup(id, request)); //서비스에 updateGroup
    }

    //group 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable int id) {
        groupService.deleteGroup(id); //서비스에 deleteGroup
        return ResponseEntity.ok().body(null);
    }

    //group 불러오기(하위 할 일)
    @GetMapping("/{id}/tasks")
    public ResponseEntity<TaskListResponse> getGroupTasks(@PathVariable int id) {
        return ResponseEntity.ok().body(groupService.findAllTasks(id));
    }

}
