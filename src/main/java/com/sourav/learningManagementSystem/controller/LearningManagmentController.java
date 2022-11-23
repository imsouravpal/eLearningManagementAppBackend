package com.sourav.learningManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.learningManagementSystem.model.Course;
import com.sourav.learningManagementSystem.model.Users;
import com.sourav.learningManagementSystem.service.CourseService;
import com.sourav.learningManagementSystem.service.UserService;

@RestController
@RequestMapping("api/v1.0")
@CrossOrigin("http://localhost:4200")
public class LearningManagmentController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;
	
	// Register a user
	@PostMapping("/lms/company/register")
	public ResponseEntity<?> registerUser(@RequestBody Users user) {
		if(userService.addUser(user) != null) {
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Unable to add user. Please provide diffrent username", HttpStatus.CONFLICT);
	}
	
	// Add a course
	@PostMapping("/lms/courses/add/")
	public ResponseEntity<?> addNewCourse(@RequestBody Course course) {
		if(courseService.addCourse(course) != null) {
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Unable to add course.", HttpStatus.CONFLICT);
	}
	
	// View a Course by Technology
	@GetMapping("/lms/courses/info/{technology}")
	public ResponseEntity<?> courseDetails(@PathVariable String technology) {
		Course courseDetails = courseService.findCourse(technology);
		if(courseDetails != null) {
			return new ResponseEntity<Course>(courseDetails, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Unable to find the course.", HttpStatus.NOT_FOUND);
	}

	// View all courses available in system
	@GetMapping("/lms/courses/getall")
	public ResponseEntity<?> getAllCourses() {
		List<Course> courseList = courseService.getAllCourses();
		if(courseList == null) {
			return new ResponseEntity<String>("No course available now", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}
	
	// Delete a course from system
	@DeleteMapping("/lms/courses/delete/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable String courseId) {
		if(courseService.deleteCourseById(courseId)) {
			return new ResponseEntity<String>("Course sucessfully deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Course not found", HttpStatus.NOT_FOUND);
	}

}
