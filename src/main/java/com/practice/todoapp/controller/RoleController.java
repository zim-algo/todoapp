package com.practice.todoapp.controller;

import com.practice.todoapp.entity.Role;
import com.practice.todoapp.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;


    public RoleController (RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAll(){
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Role> getById(@PathVariable Integer id){
        return roleService.getById(id);
    }
}
