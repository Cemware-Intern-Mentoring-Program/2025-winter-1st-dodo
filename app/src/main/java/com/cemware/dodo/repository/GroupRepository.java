package com.cemware.dodo.repository;

import com.cemware.dodo.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}