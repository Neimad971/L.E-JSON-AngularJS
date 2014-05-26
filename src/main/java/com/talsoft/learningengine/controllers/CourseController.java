package com.talsoft.learningengine.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.talsoft.learningengine.domain.Course;

@Controller
public class CourseController 
{
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
	public List<Course> showAllCourses() 
	{
		List<Course> courses = Lists.newArrayList();
		
		for(int i=0; i<5;i++)
		{
			Course c = new Course();
			c.setIdCourse(i);
			c.setName("course's name" +i);
			c.setDescription("des" +i);
			c.setOnline(false);
			c.setValidated(true);
			
			courses.add(c);
			
		}
		
		return courses;
	}
	
	
	@RequestMapping(value = "/courses/{id}", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
	public Course showOneCourse(@PathVariable long id) 
	{
		Course c = new Course();
		c.setIdCourse(id);
		c.setName("JAVA");
		c.setDescription("A complete JAVA course for dummies");
		c.setOnline(false);
		c.setValidated(true);
		
		return c;
	}
}
