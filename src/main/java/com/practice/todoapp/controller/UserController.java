package com.practice.todoapp.controller;

import com.practice.todoapp.entity.User;
import com.practice.todoapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable Integer id){
        userService.update(user, id);
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/{id}/activate")
    public void activateUser(@PathVariable Integer id){
        userService.updateStatus(id, true);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateUser(@PathVariable Integer id){
        userService.updateStatus(id, false);
    }
}
