package com.sourav.learningManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.learningManagementSystem.model.Course;

public interface CourseRepository extends JpaRepository<Course, String>{

}
