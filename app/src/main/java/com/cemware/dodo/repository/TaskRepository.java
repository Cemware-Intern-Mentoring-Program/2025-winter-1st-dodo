package com.cemware.dodo.repository;

import com.cemware.dodo.domain.Group;
import com.cemware.dodo.domain.Task;
import com.cemware.dodo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByGroup(Group group);
}