package com.cemware.dodo.dto.user;

import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.cemware.dodo.domain.User;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;
    private String userEmail;
    private String password;

    public static UserDto from(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .userEmail(user.getUserEmail())
                .password(user.getPassword())
                .build();
    }

}
