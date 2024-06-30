package com.example.serviceB.controller;

import com.example.serviceB.config.ServiceAClient;
import com.example.serviceB.domain.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceBController {

    @Autowired
    private ServiceAClient serviceAClient;

    @GetMapping("/call-service-A")
    public List<UserResponse> callServiceA(){

        return serviceAClient.getUsersFromServiceA();

    }

    @GetMapping("/call-service-A-for-single-user/{id}")
    public UserResponse callServiceAForSingleUser(@PathVariable int id){

        return serviceAClient.getUserDetailsFromServiceA(id);

    }
}
