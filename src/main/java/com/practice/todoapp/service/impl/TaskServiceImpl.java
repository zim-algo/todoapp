package com.practice.todoapp.service.impl;

import com.practice.todoapp.entity.Task;
import com.practice.todoapp.entity.User;
import com.practice.todoapp.repository.TaskRepo;
import com.practice.todoapp.repository.UserRepo;
import com.practice.todoapp.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepo taskRepo;

    private UserRepo userRepo;

    public TaskServiceImpl(TaskRepo taskRepo, UserRepo userRepo){
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }
    @Override
    public void save(Task task, Integer userId) {
        if (userRepo.existsById(userId)){
            task.setCreatedDate(LocalDate.now());
            task.setUpdatedDate(LocalDate.now());

            User newUser = new User();
            newUser.setId(userId);

            task.setStatus(false);

            task.setUser(newUser);

            taskRepo.save(task);
        }
    }

    @Override
    public List<Task> getAll() {
        return taskRepo.findAll();
    }

    @Override
    public Optional<Task> getById(Integer userId, Integer taskId) {

        if (!userRepo.existsById(userId)){
            throw new RuntimeException("User can not be found");
        }
        return taskRepo.findById(taskId);
    }

    @Override
    public void delete(Integer userId, Integer id) {

        if(!userRepo.existsById(userId)) {
            throw new RuntimeException("Task can not be found");
        }
        else taskRepo.deleteById(id);
    }

    @Override
    public void update(Task newTask, Integer id) {

        Optional<Task> taskOptional = taskRepo.findById(id);

        if(taskOptional.isPresent()){

            Task task = taskOptional.get();

            task.setTitle(newTask.getTitle());
            task.setDeadline(newTask.getDeadline());
            task.setDescription(newTask.getDescription());
            task.setStatus(newTask.getStatus());
            task.setCompletionDate(newTask.getCompletionDate());

            taskRepo.save(task);
        }
        else throw new RuntimeException("Task not found");

    }

    @Override
    public List<Task> getTasksByUserId(Integer userId) {

        if (userRepo.existsById(userId)){
            return taskRepo.getTasksByUserId(userId);
        }
       else throw new RuntimeException("User not found");
    }

    @Override
    public void updateStatus(Integer taskId, Boolean status) {

        Optional<Task> taskOptional = taskRepo.findById(taskId);

        if (!taskOptional.isPresent()){
            throw new RuntimeException("Task not found");
        }
        Task task = taskOptional.get();

        if (status){
            task.setCompletionDate(LocalDate.now());
        }
        else task.setCompletionDate(null);

        task.setStatus(status);
        taskRepo.save(task);
    }
}
