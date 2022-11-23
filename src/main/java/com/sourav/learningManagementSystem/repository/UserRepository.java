package com.sourav.learningManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.learningManagementSystem.model.Users;

public interface UserRepository extends JpaRepository<Users, String>{

}
