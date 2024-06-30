package com.example.serviceA.service;

import com.example.serviceA.domain.UserResponse;
import com.example.serviceA.entity.UserDetails;
import com.example.serviceA.repository.ServiceARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServiceAServiceImpl implements ServiceAService{

    @Autowired
    private ServiceARepository serviceARepository;

    @Override
    public UserResponse getUserDetailsbyId(int id) {
        log.info("Get the flight for flight Number: {}", id);
        UserDetails userData = serviceARepository.findById(id);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userData, userResponse);

        return userResponse;

    }

    @Override
    public List<UserResponse> getAllUsersDetails() {

        List<UserDetails> userDataList = serviceARepository.findAll();

        List<UserResponse> userResponseList = userDataList
                .stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());

        return userResponseList;
    }

    private UserResponse mapToUserResponse(UserDetails userDetails) {
        UserResponse userResponseList = new UserResponse();
        BeanUtils.copyProperties(userDetails, userResponseList);
        return userResponseList;

    }
}
