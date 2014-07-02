package com.talsoft.learningengine.domain;

import org.joda.time.DateTime;


public class Assessment 
{
	
	private int idAssessment;
	private String title;
	private DateTime dateOfAssessment;
	private int duration;
	//private AssessmentResult assessmentResult;


	public int getIdAssessment() 
	{
		return idAssessment;
	}


	public void setIdAssessment(int idAssessment)
	{
		this.idAssessment = idAssessment;
	}


	public String getTitle() 
	{
		return title;
	}


	public void setTitle(String title) 
	{
		this.title = title;
	}


	public DateTime getDateOfAssessment() 
	{
		return dateOfAssessment;
	}


	public void setDateOfAssessment(DateTime dateOfAssessment) 
	{
		this.dateOfAssessment = dateOfAssessment;
	}


	public int getDuration() 
	{
		return duration;
	}


	public void setDuration(int duration) 
	{
		this.duration = duration;
	}


	/*public AssessmentResult getAssessmentResult() 
	{
		return assessmentResult;
	}


	public void setAssessmentResult(AssessmentResult assessmentResult) 
	{
		this.assessmentResult = assessmentResult;
	}*/
	
	
	
}
