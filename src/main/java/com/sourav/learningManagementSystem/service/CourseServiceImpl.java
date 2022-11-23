package com.sourav.learningManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.learningManagementSystem.model.Course;
import com.sourav.learningManagementSystem.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public Course addCourse(Course course) {
		Optional<Course> optional = courseRepository.findById(course.getCourseId());
		if(optional.isPresent()) {
			LOG.error("Course is already exist");
		}
		return courseRepository.saveAndFlush(course);
	}

	@Override
	public boolean deleteCourseById(String courseId) {
		if(courseId != null) {
			courseRepository.deleteById(courseId);
			return true;
		}
		return false;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courseList = courseRepository.findAll();
		if(courseList != null) {
			return courseList;
		}
		return null;
	}

	@Override
	public Course findCourse(String technology) {
		return courseRepository.findById(technology).get();
	}

}
