package com.practice.todoapp.service;

import com.practice.todoapp.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> getAll();

     Optional<Role> getById(Integer id);

}
