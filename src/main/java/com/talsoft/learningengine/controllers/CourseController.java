package com.talsoft.learningengine.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.talsoft.learningengine.data.LearningEngineDatabase;
import com.talsoft.learningengine.domain.Course;

@Controller
public class CourseController 
{
	
	
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
	public List<Course> showAllCourses() 
	{
		for(int i=0; i<3;i++)
		{
			Course c = new Course();
			c.setIdCourse(i);
			c.setName("course's name " +i);
			c.setDescription("description " +i);
			
			if(i % 2 == 0)
			{
				c.setOnline(false);
			}
			else
			{
				c.setOnline(true);
			}
			
			c.setValidated(false);
			c.setFollowed(false);
		
			LearningEngineDatabase.addCourse(c);
		}
		return LearningEngineDatabase.getAllCourses();
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
	
	
	
	@RequestMapping(value="/subscribe", method = RequestMethod.POST, produces = "application/json",headers="Accept=application/json")
	@ResponseBody 
	public String subscribeToACourse(@RequestBody String courses) 
	{    
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Course> coursesFromJSON = null;
		try 
		{
			coursesFromJSON = mapper.readValue( courses, mapper.getTypeFactory().constructCollectionType(List.class, Course.class));
		} catch (JsonParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Course current : coursesFromJSON)
		{
			LearningEngineDatabase.addMyCourse(current);
		}
		
	    return courses;
	}
	
	
	
	@RequestMapping(value = "/mycourses", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
	public List<Course> showMyCourses() 
	{
		return LearningEngineDatabase.getMyCourses();
	}
	
	
	
}
