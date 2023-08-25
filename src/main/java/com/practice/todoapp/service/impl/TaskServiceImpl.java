package com.practice.todoapp.service.impl;

import com.practice.todoapp.entity.Task;
import com.practice.todoapp.repository.TaskRepo;
import com.practice.todoapp.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }
    @Override
    public void save(Task task) {
        taskRepo.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepo.findAll();
    }

    @Override
    public Optional<Task> getById(Integer id) {

        if (taskRepo.existsById(id)){
            return taskRepo.findById(id);
        }
        else throw new RuntimeException("Task can not be found");
    }

    @Override
    public void delete(Integer id) {
        taskRepo.deleteById(id);
    }

    @Override
    public void update(Task newTask, Integer id) {

        Optional<Task> taskOptional = getById(id);

        if(taskOptional.isPresent()){

            Task task = taskOptional.get();

            task.setTitle(newTask.getTitle());
            task.setDeadline(newTask.getDeadline());
            task.setDescription(newTask.getDescription());
            task.setStatus(newTask.getStatus());
            task.setCompletionDate(newTask.getCompletionDate());

            taskRepo.save(task);
        }
        throw new RuntimeException("Task not found");

    }
}
