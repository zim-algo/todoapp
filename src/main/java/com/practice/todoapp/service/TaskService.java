package com.practice.todoapp.service;

import com.practice.todoapp.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    void save (Task task, Integer userId);

    List<Task> getAll();

    Optional<Task> getById(Integer userId, Integer taskId);

    void delete(Integer userId, Integer id);

    void update(Task newTask, Integer id);

    List<Task> getTasksByUserId (Integer userId);

    void updateStatus(Integer taskId, Boolean status);
}
