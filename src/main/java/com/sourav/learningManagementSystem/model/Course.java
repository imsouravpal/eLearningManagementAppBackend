package com.sourav.learningManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	private String courseId;
	private String courseName;
	private double courseDuration;
	private String courseDescription;
	private String technology;
	private String lunchUrl;
	
	public Course() {
		super();
	}
	public Course(String courseId, String courseName, double courseDuration, String courseDescription, String technology,
			String lunchUrl) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseDescription = courseDescription;
		this.technology = technology;
		this.lunchUrl = lunchUrl;
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(double courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getLunchUrl() {
		return lunchUrl;
	}
	public void setLunchUrl(String lunchUrl) {
		this.lunchUrl = lunchUrl;
	}

}
