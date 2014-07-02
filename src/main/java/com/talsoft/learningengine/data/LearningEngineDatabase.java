package com.talsoft.learningengine.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.joda.time.DateTime;

import com.google.common.collect.Lists;
import com.talsoft.learningengine.domain.Assessment;
import com.talsoft.learningengine.domain.AssessmentResult;
import com.talsoft.learningengine.domain.Course;

public class LearningEngineDatabase 
{
	private static  LearningEngineDatabase instance = null;
	private List<Course> courses; 		   					// ALL COURSES
	private List<Course> followedCourses;  					// MY COURSES AS STUDENT
	private List<AssessmentResult> assessmentResults;		// MY RESULTS AS STUDENT
	private List<Assessment> assessments;
	
	
	private LearningEngineDatabase() 
	{
		courses = Lists.newArrayList();
		followedCourses = Lists.newArrayList();
		assessmentResults = Lists.newArrayList();
		assessments = Lists.newArrayList();
		
		initDatabase();
		
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
	
	
	private void initDatabase()
	{
		initWithCourses();
		initWithAssessmentResults();
		initWithAssessments();
	}
	
	
	private void initWithCourses()
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
	
	
	private void initWithAssessmentResults()
	{
		for(int i=0; i<3;i++)
		{
			AssessmentResult ar = new AssessmentResult();
			ar.setIdAssessmentResult(i);
			ar.setAssessmentName("assessment result's name " +i);
			ar.setScore(i * 10);
			
			if(ar.getScore() < 10)
			{
				ar.setStatus(false);
			}
			else
			{
				ar.setStatus(true);
			}	
			
			assessmentResults.add(ar);
		}
	}
	
	
	private void initWithAssessments()
	{
		for(int i=0; i<3;i++)
		{
			Assessment a = new Assessment();
			a.setIdAssessment(i);
			a.setTitle("assessment's name " +i);
			a.setDateOfAssessment(new DateTime());
			a.setDuration(i + 2);
			
			assessments.add(a);
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
	
	
	public static List<AssessmentResult> getMyAssessmentResults()
	{
		return getInstance().getAssessmentResults();
	}
	

	public static void addAssessmentResults(AssessmentResult assessmentResult)
	{
		getInstance().getAssessmentResults().add(assessmentResult);
	}
	
	
	public static List<Assessment> getMyAssessments()
	{
		return getInstance().getAssessments();
	}
	

	public static void addAssessment(Assessment assessment)
	{
		getInstance().getAssessments().add(assessment);
	}



	private List<Course> getCourses() 
	{
		return courses;
	}


	private List<Course> getFollowedCourses() 
	{
		return followedCourses;
	}



	private List<AssessmentResult> getAssessmentResults() 
	{
		return assessmentResults;
	}


	private List<Assessment> getAssessments()
	{
		return assessments;
	}
}
