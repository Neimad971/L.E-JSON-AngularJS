package com.talsoft.learningengine.data;

import java.util.List;

import com.google.common.collect.Lists;
import com.talsoft.learningengine.domain.Course;

public class LearningEngineDatabase 
{
	private static  LearningEngineDatabase instance = null;
	private List<Course> courses; // ALL COURSES
	private List<Course> followedCourses;  //MY COURSES AS STUDENT
	
	
	private LearningEngineDatabase() 
	{
		courses = Lists.newArrayList();
		followedCourses = Lists.newArrayList();
		init();
		
	}
	
	
	
	private static LearningEngineDatabase getInstance()
	{	
		if (instance == null)
		{
			synchronized (LearningEngineDatabase.class) 
			{
				instance = new LearningEngineDatabase();	
			}
		}
		
		return instance;
	}
	
	
	private void init()
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
			courses.add(c);
		
		}
	}
	
	
	public static List<Course> getAllCourses()
	{
		return getInstance().getCourses();
	}
	

	public static void addCourse(Course course)
	{
		getInstance().getCourses().add(course);
	}
	
	
	public static List<Course> getMyCourses()
	{
		return getInstance().getFollowedCourses();
	}
	

	public static void addMyCourse(Course course)
	{
		getInstance().getFollowedCourses().add(course);
	}


	private List<Course> getCourses() 
	{
		return courses;
	}


	private List<Course> getFollowedCourses() 
	{
		return followedCourses;
	}




	
	
	
	
	
	
	/*public static List<Tag> getAllTags()
	{
		return getInstance().getTags();
	}
	
	
	public static void addTag(Tag tag)
	{
		getInstance().getTags().add(tag);
	}
	
	
	public static List<Note> getAllNotesWithTagName(String tagName)
	{
		List<Note> filteredList = Lists.newArrayList();
		
		for(Note current : getInstance().getNotes())
		{
			if(current.getTagName().equalsIgnoreCase(tagName))
			{
				filteredList.add(current);
			}
		}
		
		return filteredList;
	}*/
}
