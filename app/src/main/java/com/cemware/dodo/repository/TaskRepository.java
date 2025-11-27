package com.cemware.dodo.repository;

import com.cemware.dodo.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}