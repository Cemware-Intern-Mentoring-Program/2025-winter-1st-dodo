package com.cemware.dodo.dto.user;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.cemware.dodo.domain.User;


@Getter
@Builder
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //전체 필드 생성자
public class UserUpdateRequest {

    private String userEmail;
    private String password;

}
