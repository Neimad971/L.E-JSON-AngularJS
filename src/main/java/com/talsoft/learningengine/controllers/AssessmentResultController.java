package com.talsoft.learningengine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talsoft.learningengine.domain.AssessmentResult;
import com.talsoft.learningengine.services.AssessmentResultService;

@Controller
public class AssessmentResultController 
{

	@Autowired
	private AssessmentResultService aResultService;
	
	
	public AssessmentResultService getaResultService() 
	{
		return aResultService;
	}


	public void setaResultService(AssessmentResultService aResultService) 
	{
		this.aResultService = aResultService;
	}


	@RequestMapping(value = "/results", method = RequestMethod.GET, produces = "application/json",headers="Accept=application/json")
	@ResponseBody
	public List<AssessmentResult> showAssessmentResult() 
	{	
		return  aResultService.showAssessmentResult();
	}
	
	
	@RequestMapping(value="/dropoffresult", method = RequestMethod.POST, produces = "application/json",headers="Accept=application/json")
	@ResponseBody 
	public String dropOffAssessementResult(@RequestBody String result) 
	{    
		aResultService.dropOffAssessementResult(result);
		
	    return result;
	}
}
