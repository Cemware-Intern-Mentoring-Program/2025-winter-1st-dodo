package com.cemware.dodo;

import com.cemware.dodo.domain.User;
import com.cemware.dodo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// cannot resolve symbol 'orm' 에러가 뜨는데 이유를 모르겠습니다
import org.springframework.boot.test.context.SpringBootTest;

// Source - https://stackoverflow.com/a
// Posted by Aliuk
// Retrieved 2025-12-16, License - CC BY-SA 4.0

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // 여기서도 cannot resolve symbol '@DataJpaTest' 에러가 뜨는데 이유를 모르겠습니다
@Transactional
class UserRepositoryTest{

    private UserRepository userRepository;

    @Test
    @DisplayName("Repository layer 유저 조회")
    void findUserById() {

        // given: 유저 저장
        User user = User.builder()
                .userEmail("dodo@cemware.com")
                .password("1234")
                .build();

        User savedUser = userRepository.save(user);
        int userId = savedUser.getUserId();

        // when: ID로 조회
        Optional<User> foundUser = userRepository.findById(userId);

        // then: 조회 검증
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUserEmail()).isEqualTo(user.getUserEmail());
        assertThat(foundUser.get().getPassword()).isEqualTo(user.getPassword());

    }
}