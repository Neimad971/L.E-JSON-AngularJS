package com.talsoft.learningengine.domain;



public class AssessmentResult 
{
	
	private int idAssessmentResult;
	private String assessmentName;
	private int score;
	private boolean status;
	
	
	
	public String getAssessmentName() 
	{
		return assessmentName;
	}

	public void setAssessmentName(String assemssmentName) 
	{
		this.assessmentName = assemssmentName;
	}

	public int getIdAssessmentResult() 
	{
		return idAssessmentResult;
	}
	
	public void setIdAssessmentResult(int idAssessmentResult) 
	{
		this.idAssessmentResult = idAssessmentResult;
	}
	
	public int getScore() 
	{
		return score;
	}
	
	public void setScore(int score) 
	{
		this.score = score;
	}
	
	public boolean isStatus() 
	{
		return status;
	}
	
	public void setStatus(boolean status) 
	{
		this.status = status;
	}	
}
