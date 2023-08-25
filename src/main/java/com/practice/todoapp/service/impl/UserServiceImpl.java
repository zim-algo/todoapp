package com.practice.todoapp.service.impl;

import com.practice.todoapp.entity.User;
import com.practice.todoapp.repository.UserRepo;
import com.practice.todoapp.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

      private UserRepo userRepo;

      public UserServiceImpl (UserRepo userRepo){
          this.userRepo = userRepo;
      }

    @Override
    public void save(User user) {

          user.setStatus(true);
          user.setCreatedDate(LocalDate.now());
          user.setUpdatedDate(LocalDate.now());
          userRepo.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {

          if(userRepo.existsById(id)){
              return userRepo.findById(id);
          }
         else throw new RuntimeException("User not found");
    }

    @Override
    public void update(User newUser, Integer id) {

          Optional<User> userOptional = getById(id);

          if(userOptional.isPresent()){

              User user = userOptional.get();

              user.setEmail(newUser.getEmail());
              user.setFirstName(newUser.getFirstName());
              user.setPassword(newUser.getFirstName());
              user.setLastName(newUser.getLastName());
              user.setStatus(newUser.getStatus());
              user.setUpdatedDate(LocalDate.now());

              userRepo.save(user);
          }

          else throw new RuntimeException("User not found");
    }
}
