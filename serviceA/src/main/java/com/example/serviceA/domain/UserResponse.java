package com.example.serviceA.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private int Id;
    private String name;
    private String password;
    private int phone;
    private String email;
    private int age;


}
