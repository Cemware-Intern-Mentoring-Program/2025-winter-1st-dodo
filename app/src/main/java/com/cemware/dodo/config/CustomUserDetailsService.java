package com.cemware.dodo.config;

import com.cemware.dodo.domain.User;
import com.cemware.dodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * userEmail을 이용해 사용자 정보를 조회
     */
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUserEmail(userEmail);

        // 사용자가 존재하지 않을 경우 예외 throw
        User user = userOptional.orElseThrow(() -> {
            log.warn("사용자를 찾을 수 없습니다: username={}", userEmail);
            return new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + userEmail);
        });

        return new CustomUserDetails(user);
    }

}