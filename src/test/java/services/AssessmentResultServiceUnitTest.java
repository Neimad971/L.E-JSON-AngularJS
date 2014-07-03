package services;

import java.io.IOException;

import junit.framework.Assert;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.talsoft.learningengine.dao.AssessmentResultDao;
import com.talsoft.learningengine.domain.AssessmentResult;
import com.talsoft.learningengine.services.AssessmentResultService;

public class AssessmentResultServiceUnitTest {
	private AssessmentResultService assessmentResultService;
	private AssessmentResultDao mAssessmentResultDao;
	
	@Before
	public void initialiser() {
		assessmentResultService = new AssessmentResultService();
		mAssessmentResultDao = EasyMock.createMock(AssessmentResultDao.class);
	}
	
	@Test
	public void test_dropOffAssessementResult() throws JsonParseException, JsonMappingException, IOException {
		AssessmentResult assessmentResult = new AssessmentResult();
		assessmentResult.setAssessmentName("Evaluation 1");
		assessmentResult.setIdAssessmentResult(1);
		assessmentResult.setScore(20);
		assessmentResult.setStatus(true);
		
		assessmentResultService.setaResultDao(mAssessmentResultDao);
		mAssessmentResultDao.insert((AssessmentResult) EasyMock.anyObject());
		
		EasyMock.replay(mAssessmentResultDao);
		String result = assessmentResultService.dropOffAssessementResult("{\"assessmentName\": \"Histoire\",\"score\": 5}");
		EasyMock.verify(mAssessmentResultDao);
		
		Assert.assertEquals("{\"assessmentName\": \"Histoire\",\"score\": 5}", result);
	}
}
