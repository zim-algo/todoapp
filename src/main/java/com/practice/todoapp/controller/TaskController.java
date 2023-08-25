package com.practice.todoapp.controller;

import com.practice.todoapp.entity.Task;
import com.practice.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;


    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getById(@PathVariable Integer id){
        return taskService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        taskService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Task task, @PathVariable Integer id){
        taskService.update(task, id);
    }

    @PostMapping
    public void save (@RequestBody Task task){
        taskService.save(task);
    }

}
