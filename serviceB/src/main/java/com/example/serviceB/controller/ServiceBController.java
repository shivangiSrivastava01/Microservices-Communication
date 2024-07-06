package com.example.serviceB.controller;

import com.example.serviceB.config.ServiceAClient;
import com.example.serviceB.domain.UserResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ServiceBController {

    @Value("${rest.user.details.baseUrl}")
    private String userDetailsURL;

    private final RestTemplate restTemplate;

    @Autowired
    public ServiceBController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private ServiceAClient serviceAClient;

    @HystrixCommand(fallbackMethod = "fallBackSevice")
    @GetMapping("/call-service-A")
    public List<UserResponse> callServiceA(){

        return serviceAClient.getUsersFromServiceA();

    }

    public String fallBackSevice() {
        return "Fallback Hello";
    }

    @GetMapping("/call-service-A-for-single-user/{id}")
    public UserResponse callServiceAForSingleUser(@PathVariable int id){

        return serviceAClient.getUserDetailsFromServiceA(id);

    }

    @GetMapping("/dataBaseUsers")
    public List<UserResponse> getAllUsers(){

        HttpEntity<String> requestEntity = getHttpEntity();

        ResponseEntity<List<UserResponse>>responseEntity = restTemplate.exchange(userDetailsURL, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {
        });
        return responseEntity.getBody();
    }

    private static HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return requestEntity;
    }


}
