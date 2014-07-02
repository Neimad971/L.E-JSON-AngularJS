package com.talsoft.learningengine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talsoft.learningengine.dao.AssessmentDao;
import com.talsoft.learningengine.domain.Assessment;

@Component
public class AssessmentService 
{
	@Autowired
	private AssessmentDao assessmentDao;
	
	public AssessmentDao getAssessmentDao() 
	{
		return assessmentDao;
	}

	public void setAssessmentDao(AssessmentDao assessmentDao) 
	{
		this.assessmentDao = assessmentDao;
	}


	public List<Assessment> showAssessments() 
	{
		return assessmentDao.findAll();
	}

}
