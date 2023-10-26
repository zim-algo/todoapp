package com.practice.todoapp.controller;

import com.practice.todoapp.entity.Task;
import com.practice.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/{userId}/tasks")
public class TaskController {

    private TaskService taskService;


    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll(@PathVariable Integer userId){
        return taskService.getAll();
    }

    @GetMapping("/taskId}")
    public Optional<Task> getById(@PathVariable Integer taskId, @PathVariable Integer userId){
        return taskService.getById(taskId, userId);
    }

    @DeleteMapping("/{taskId}")
    public void deleteById(@PathVariable Integer userId, @PathVariable Integer taskId){
        taskService.delete(userId, taskId);
    }

    @PutMapping("/{taskId}")
    public void update(@RequestBody Task task, @PathVariable Integer taskId){
        taskService.update(task, taskId);
    }

    @PostMapping
    public void save (@RequestBody Task task, @PathVariable Integer userId){
        taskService.save(task, userId);
    }

    @PutMapping("/{taskId}/markTaskComplete")
    public void markTaskComplete(@PathVariable Integer taskId){
        taskService.updateStatus(taskId, true);
    }

    @PutMapping("/{taskId}/markTaskInComplete")
    public void markTaskInComplete(@PathVariable Integer taskId){
        taskService.updateStatus(taskId, false);
    }



}
