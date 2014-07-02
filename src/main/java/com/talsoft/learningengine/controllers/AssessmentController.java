package com.talsoft.learningengine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talsoft.learningengine.domain.Assessment;
import com.talsoft.learningengine.services.AssessmentService;

@Controller
public class AssessmentController 
{
	
	@Autowired
	private AssessmentService assessmentService;
	
	public AssessmentService getAssessmentService() 
	{
		return assessmentService;
	}

	public void setAssessmentService(AssessmentService assessmentService) 
	{
		this.assessmentService = assessmentService;
	}



	@RequestMapping(value = "/assessments", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
	public List<Assessment> showAssessments() 
	{
		return assessmentService.showAssessments();
	}
}
