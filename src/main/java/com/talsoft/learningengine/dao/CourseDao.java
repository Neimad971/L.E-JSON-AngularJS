package com.talsoft.learningengine.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talsoft.learningengine.data.LearningEngineDatabase;
import com.talsoft.learningengine.domain.Course;

@Component
public class CourseDao  
{

	
	public List<Course> findAll() 
	{
		return LearningEngineDatabase.getAllCourses();
	}

	
	public void insert(Course course) 
	{
		LearningEngineDatabase.addMyCourse(course);
	}

}
