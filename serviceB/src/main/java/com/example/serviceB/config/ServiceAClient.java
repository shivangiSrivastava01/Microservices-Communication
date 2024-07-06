package com.example.serviceB.config;


import com.example.serviceB.domain.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "serviceAClient", url = "http://localhost:7026")
public interface ServiceAClient {

    @GetMapping(value = "/users")
    List<UserResponse> getUsersFromServiceA();

    @GetMapping(value = "/user/{id}")
    UserResponse getUserDetailsFromServiceA(@PathVariable int id);

}
