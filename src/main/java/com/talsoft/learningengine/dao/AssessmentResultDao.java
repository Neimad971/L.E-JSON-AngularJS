package com.talsoft.learningengine.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talsoft.learningengine.data.LearningEngineDatabase;
import com.talsoft.learningengine.domain.AssessmentResult;

@Component
public class AssessmentResultDao 
{
	public List<AssessmentResult> findAll() 
	{
		return LearningEngineDatabase.getMyAssessmentResults();	
	}
	
	
	public void insert(AssessmentResult aResult) 
	{
		LearningEngineDatabase.addAssessmentResults(aResult);
	}
}

