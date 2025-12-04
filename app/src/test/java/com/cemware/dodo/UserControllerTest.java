package com.cemware.dodo;

import com.cemware.dodo.dto.user.UserDto;
import com.cemware.dodo.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Controller layer 유저 조회")
    void getUserById() throws Exception {

        // given
        UserDto mockUser = new UserDto(1, "dodo@cemware.com", "1234");

        Mockito.when(userService.getUser(anyInt()))
                .thenReturn(mockUser);

        // when & then
        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.userEmail").value("dodo@cemware.com"))
                .andExpect(jsonPath("$.password").value("1234"));
    }
}
