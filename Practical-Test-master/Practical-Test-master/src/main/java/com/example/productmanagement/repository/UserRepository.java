package com.example.productmanagement.repository;

import com.example.productmanagement.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByusername(String username);
}
