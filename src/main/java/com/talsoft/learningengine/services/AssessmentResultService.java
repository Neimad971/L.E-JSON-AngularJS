package com.talsoft.learningengine.services;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talsoft.learningengine.dao.AssessmentResultDao;
import com.talsoft.learningengine.domain.AssessmentResult;
import com.talsoft.learningengine.domain.Course;

@Component
public class AssessmentResultService 
{
	@Autowired
	private AssessmentResultDao  aResultDao;
	
	
	public AssessmentResultDao getaResultDao()
	{
		return aResultDao;
	}

	public void setaResultDao(AssessmentResultDao aResultDao) 
	{
		this.aResultDao = aResultDao;
	}

	public List<AssessmentResult> showAssessmentResult() 
	{
		return aResultDao.findAll();	
	}
	
	
	public String dropOffAssessementResult(String result) 
	{
		AssessmentResult aResult = convertJsonAssessmentResultToAssessmentResult(result); 
		aResultDao.insert(aResult);
		
		return result;
	}
	
	
	public AssessmentResult convertJsonAssessmentResultToAssessmentResult(String jsonString)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		AssessmentResult aResultFromJSON = null;
		try 
		{
			aResultFromJSON = mapper.readValue(jsonString, AssessmentResult.class); 
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
		
		return aResultFromJSON;
	}
	
	
	
}

