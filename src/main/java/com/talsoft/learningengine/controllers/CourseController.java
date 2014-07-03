package com.talsoft.learningengine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talsoft.learningengine.domain.Course;
import com.talsoft.learningengine.services.CourseService;


@Controller
public class CourseController 
{
	
	@Autowired
	private CourseService courseService;
	

	
	public void setCourseService(CourseService courseService) 
	{
		this.courseService = courseService;
	}
	

	public CourseService getCourseService() 
	{
		return courseService;
	}

	
	@RequestMapping(value = "/courses", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
	public List<Course> showAllCourses() 
	{	
		return  courseService.showAllCourses();
	}
	
	
	@RequestMapping(value="/subscribe", method = RequestMethod.POST, produces = "application/json",headers="Accept=application/json")
	@ResponseBody 
	public String subscribeToACourse(@RequestBody String courses) 
	{    
		courseService.subscribeToACourse(courses);
		
	    return courses;
	}
	
	
	@RequestMapping(value = "/mycourses", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
	public List<Course> showMyCourses() 
	{
		return courseService.showMyCourses();
	}
	
	
	@RequestMapping(value="/dropoffcourse", method = RequestMethod.POST, produces = "application/json",headers="Accept=application/json")
	@ResponseBody 
	public String dropOffCourse(@RequestBody String course) 
	{    
		courseService.dropOffCourse(course);
		
	    return course;
	}
	
	
	
	
	
}
