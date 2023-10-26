package com.practice.todoapp.repository;

import com.practice.todoapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    public List<Task> getTasksByUserId(Integer userId);
}
