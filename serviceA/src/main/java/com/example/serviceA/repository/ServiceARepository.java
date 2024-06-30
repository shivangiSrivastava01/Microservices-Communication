package com.example.serviceA.repository;
import com.example.serviceA.domain.UserResponse;
import com.example.serviceA.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceARepository extends JpaRepository<UserDetails, Long>{

     UserDetails findById(int id);

     List<UserDetails> findAll();
}
