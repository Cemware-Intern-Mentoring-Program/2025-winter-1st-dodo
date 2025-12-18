package com.cemware.dodo.service;

import com.cemware.dodo.domain.Group;
import com.cemware.dodo.domain.Task;
import com.cemware.dodo.dto.group.*;
import com.cemware.dodo.dto.task.TaskDto;
import com.cemware.dodo.dto.task.TaskListResponse;
import com.cemware.dodo.repository.GroupRepository;
import com.cemware.dodo.repository.TaskRepository;
import com.cemware.dodo.domain.User;
import com.cemware.dodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final TaskRepository taskRepository;

    // group 생성
    public GroupDto createGroup(GroupCreateRequest request, User user) {
        Group group = Group.builder()
                //.groupId(request.getGroupId())
                .groupName(request.getGroupName())
                .user(user)
                .build();

        return GroupDto.from(groupRepository.save(group));
    }

    // group 조회(하위 할 일)
    public TaskListResponse findAllTasks(int groupId) {

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("그룹(하위 할 일) 조회 오류"));

        List<Task> tasks = taskRepository.findAllByGroup(group);

        return TaskListResponse.from(tasks.stream().map(TaskDto::from).toList());
    }

    // group 수정
    public GroupDto updateGroup(int id, GroupUpdateRequest request) {

        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("그룹 수정 오류"));

        if (request.getGroupName() != null) group.updateGroupName(request.getGroupName());

        return GroupDto.from(groupRepository.save(group));

    }

    // group 삭제 (하위 task 삭제 포함)
    public void deleteGroup(int id) {

        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("그룹 삭제 오류"));

        groupRepository.delete(group);
    }

}

