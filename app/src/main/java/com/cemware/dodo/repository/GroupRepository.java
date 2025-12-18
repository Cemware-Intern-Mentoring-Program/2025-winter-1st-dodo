package com.cemware.dodo.repository;

import com.cemware.dodo.domain.Group;
import com.cemware.dodo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findAllByUser(User user);
}