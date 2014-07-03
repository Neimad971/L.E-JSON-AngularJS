package com.talsoft.learningengine.services;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.talsoft.learningengine.dao.CourseDao;
import com.talsoft.learningengine.data.LearningEngineDatabase;
import com.talsoft.learningengine.domain.Course;

@Component
public class CourseService 
{	
	@Autowired
	private CourseDao courseDao;
	
	public List<Course> showAllCourses() 
	{	
		return (List<Course>) courseDao.findAll();
		
	}
	
	
	public String subscribeToACourse(String courses)
	{
		List<Course> coursesFromJSON = convertJsonCourseToCourseList(courses);
		
		for(Course current : coursesFromJSON)
		{
			current.setFollowed(true);
			courseDao.insertInMyCourses(current);
		}
		
		return courses;
	}
	
	
	public List<Course> showMyCourses() 
	{
		return courseDao.findMyCourses();
	}
	
	
	public String dropOffCourse(String course)
	{
		Course courseFromJSON = convertJsonCourseToCourse(course);
		
		courseDao.insert(courseFromJSON);
		
		return course;
	}
	
	
	public List<Course> convertJsonCourseToCourseList(String jsonString)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		List<Course> coursesFromJSON = null;
		try 
		{
			coursesFromJSON = mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, Course.class));
		} 
		catch (JsonParseException e) 
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
		
		return coursesFromJSON;
	}
	
	
	public Course convertJsonCourseToCourse(String jsonString)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		Course courseFromJSON = null;
		try 
		{
			courseFromJSON = mapper.readValue(jsonString, Course.class);
		} 
		catch (JsonParseException e) 
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
		
		return courseFromJSON;
		
	}
}
