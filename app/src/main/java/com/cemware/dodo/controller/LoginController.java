package com.cemware.dodo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping(
            value = "/login",
            consumes = "application/x-www-form-urlencoded"
    )
    public void login(
            @RequestParam String userEmail,
            @RequestParam String password
    ) {
        // ❗ 아무 로직도 쓰지 마
        // LoginFilter가 여기 도달하기 전에 가로챔
    }
}
