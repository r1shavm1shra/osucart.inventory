package com.example.ecommerce.controller;

import com.example.ecommerce.Model.User;
import com.example.ecommerce.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public String hello()
    {
        return "Hello World";
    }

    @GetMapping("/users")
    public List<User> getAll()
    {
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user)
    {
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user)
    {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        userRepo.save(updatedUser);
        return "updated...";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id)
    {
        userRepo.deleteById(id);
        return "deleted...";
    }

}
