package com.cemware.dodo;

import com.cemware.dodo.domain.User;
import com.cemware.dodo.dto.user.UserDto;
import com.cemware.dodo.repository.UserRepository;
import com.cemware.dodo.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Service layer 유저 조회")
    void getUserById() {
        // given
        User user = User.builder()
                .userEmail("dodo@cemware.com")
                .password("1234")
                .build();
        user.updateId(1);

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        // when
        UserDto foundUser = userService.getUser(1);

        // then
        assertThat(foundUser.getUserId()).isEqualTo(user.getUserId());
        assertThat(foundUser.getUserEmail()).isEqualTo(user.getUserEmail());
        assertThat(foundUser.getPassword()).isEqualTo(user.getPassword());
    }
}

