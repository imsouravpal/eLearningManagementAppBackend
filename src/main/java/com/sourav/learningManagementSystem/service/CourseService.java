package com.sourav.learningManagementSystem.service;

import java.util.List;

import com.sourav.learningManagementSystem.model.Course;

public interface CourseService {
	
	public Course addCourse(Course course);
	public boolean deleteCourseById(String courseId);
	public List<Course> getAllCourses();
	public Course findCourse(String technology);

}
