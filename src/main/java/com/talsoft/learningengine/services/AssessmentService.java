package com.talsoft.learningengine.services;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talsoft.learningengine.dao.AssessmentDao;
import com.talsoft.learningengine.domain.Assessment;
import com.talsoft.learningengine.domain.Course;

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
	
	
	public String dropOffAssessment(String assessment)
	{
		Assessment AssessmentFromJSON = convertJsonAssessmentToAssessment(assessment);
			
		assessmentDao.insert(AssessmentFromJSON);
			
		return assessment;
	}
	
	
	public Assessment convertJsonAssessmentToAssessment(String jsonString)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		Assessment assessmentFromJSON = null;
		try 
		{
			assessmentFromJSON = mapper.readValue(jsonString, Assessment.class);
		} 
		catch (JsonParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return assessmentFromJSON;
		
	}
	
	

}
