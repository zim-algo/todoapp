package com.practice.todoapp.service;

import com.practice.todoapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save (User user);

    void delete (Integer id);

    List<User> getAll();

    Optional<User> getById(Integer id);

    void update(User user, Integer id);
}
