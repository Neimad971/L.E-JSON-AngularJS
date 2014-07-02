package com.talsoft.learningengine.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talsoft.learningengine.data.LearningEngineDatabase;
import com.talsoft.learningengine.domain.Assessment;

@Component
public class AssessmentDao
{
	public List<Assessment> findAll() 
	{
		return LearningEngineDatabase.getMyAssessments();
	}
}
