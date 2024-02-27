package com.example.MyFirstREST.controllers;

import com.example.MyFirstREST.domain.User;
import com.example.MyFirstREST.repository.JpaRepositor;
import com.example.MyFirstREST.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")//localhost:8080/users
public class UserController {

    @Autowired
    private JpaRepositor jpaRepository;
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
//        service.getDataProcessingService().getRepository().getUsers().add(user);
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        jpaRepository.save(user);

        return "User added from body!";
    }

    @PostMapping("/addUser")
    public String userAddFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email){
        service.processRegistration(name, age, email);
        return "User added from body!";
    }

    @GetMapping("/h2")
    public List<User> getUsers() {
        return jpaRepository.findAll();
    }

}
