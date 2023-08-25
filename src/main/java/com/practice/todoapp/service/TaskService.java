package com.practice.todoapp.service;

import com.practice.todoapp.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    void save (Task task);

    List<Task> getAll();

    Optional<Task> getById(Integer id);

    void delete (Integer id);

    void update(Task newTask, Integer id);
}
