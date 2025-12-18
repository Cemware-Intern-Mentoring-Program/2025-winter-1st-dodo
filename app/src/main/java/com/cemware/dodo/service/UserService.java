package com.cemware.dodo.service;

import java.io.IOException;
import java.util.List;

import com.cemware.dodo.domain.Group;
import com.cemware.dodo.domain.User;
import com.cemware.dodo.dto.user.*;
import com.cemware.dodo.dto.group.*;
import com.cemware.dodo.repository.UserRepository;
import com.cemware.dodo.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 유저 생성
    public UserDto createUser(UserCreateRequest request) {

        User user = User.builder()
                .userEmail(request.getUserEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword())) //비밀번호를 해싱하여 유저 정보 저장
                .build();

        return UserDto.from(userRepository.save(user)); //유저 엔티티 저장
    }

    // 유저 조회
    public UserDto getUser(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자 조회 오류"));

        return UserDto.from(user);
    }

    // 유저 수정
    public UserDto updateUser(int id, UserUpdateRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자 수정 오류"));

        if (request.getUserEmail() != null) user.updateUserEmail(request.getUserEmail());
        if (request.getPassword() != null) user.updatePassword(bCryptPasswordEncoder.encode(request.getPassword()));

        return UserDto.from(userRepository.save(user));

    }


    // 유저 삭제 (하위 그룹 삭제 포함)
    public void deleteUser(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자 삭제 오류"));

        userRepository.delete(user);
        // CascadeType.ALL 이면 그룹, 태스크 자동 삭제
    }


    // 유저가 만든 그룹 전체 조회
    public GroupListResponse findAllGroups(int userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자(그룹) 조회 오류"));

        List<Group> groups = groupRepository.findAllByUser(user);

        return GroupListResponse.from(groups.stream().map(GroupDto::from).toList());
    }

}