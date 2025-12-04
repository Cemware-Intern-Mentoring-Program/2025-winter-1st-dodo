package com.cemware.dodo.controller;

import com.cemware.dodo.dto.group.GroupDto;
import com.cemware.dodo.dto.group.GroupListResponse;
import com.cemware.dodo.dto.user.*;
import com.cemware.dodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    /*
User
유저 생성하기 (1건)
유저 수정하기 (1건)
유저 삭제하기 (1건, 하위 그룹 및 할 일 삭제)
유저 불러오기 (1건)
유저 그룹 불러오기 (유저가 만든 그룹 전체 불러오기)
*/

    private final UserService userService;

    //유저 생성하기
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request)); //서비스에 createUser
    }
    /*POST 요청의 body(JSON)를
    UserCreateRequest DTO로 변환*/

    //유저 불러오기
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.getUser(id)); //서비스에 getUser
    }
    /*@PathVariable: URL 경로(path)에서 변수를 추출해 매개변수에 바인딩*/

    //유저 수정
    @PatchMapping("/{id}")
   /* HTTP PATCH 메소드의 경우, 수정하기로 명시한 데이터만 갱신되고 나머지 데이터는 그대로인데
    HTTP PUT의 경우 수정하기로 명시되지 않은 나머지 데이터는 모두 "빈 값"*/
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok().body(userService.updateUser(id, request)); //서비스에 updateUser
    }

    //유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id); //서비스에 deleteUser
        return ResponseEntity.ok().body(null);
    }

    //유저그룹 조회
    @GetMapping("/{id}/groups")
    public ResponseEntity<GroupListResponse> getUserGroups(@PathVariable int id) {
        return ResponseEntity.ok().body(userService.findAllGroups(id));
    }

}
