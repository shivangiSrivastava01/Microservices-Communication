package com.example.serviceA.service;


import com.example.serviceA.domain.UserResponse;

import java.util.List;


public interface ServiceAService {

    UserResponse getUserDetailsbyId(int id);

    List<UserResponse> getAllUsersDetails();
}
