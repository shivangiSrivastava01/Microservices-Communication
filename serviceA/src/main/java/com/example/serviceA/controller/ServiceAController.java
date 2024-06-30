package com.example.serviceA.controller;

import com.example.serviceA.domain.UserResponse;
import com.example.serviceA.service.ServiceAService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ServiceAController {


    @Autowired
    private final ServiceAService userService;

    @GetMapping("/user/{id}")
    public UserResponse getUserById(@PathVariable("id") int id) {
        log.info("getUsersById::::::::");
        return userService.getUserDetailsbyId(id);
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        log.info("getAllUsers:::::::::");
        return userService.getAllUsersDetails();
    }
}
