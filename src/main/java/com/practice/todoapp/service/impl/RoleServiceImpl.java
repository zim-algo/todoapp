package com.practice.todoapp.service.impl;

import com.practice.todoapp.entity.Role;
import com.practice.todoapp.repository.RoleRepo;
import com.practice.todoapp.service.RoleService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl (RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }


    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }

    @Override
    public Optional<Role> getById(Integer id) {

        if (roleRepo.existsById(id)) {
            return roleRepo.findById(id);
        }
        throw new RuntimeException("Role not found");
    }
}
