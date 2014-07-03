package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.talsoft.learningengine.dao.AssessmentResultDao;
import com.talsoft.learningengine.domain.AssessmentResult;

public class AssessmentResultDaoUnitTest {
	private AssessmentResultDao assessmentResultDao;
	
	@Before
	public void initialiser() {
		assessmentResultDao = new AssessmentResultDao();
	}
	
	@Test
	public void test_findAll() {
		List<AssessmentResult> assessementResultList = assessmentResultDao.findAll();
		Assert.assertTrue(assessementResultList.size() > 0);
	}
	
	@Test
	public void test_insert() {
		AssessmentResult assessmentResult = new AssessmentResult();
		assessmentResult.setAssessmentName("Histoire : début de l'ère informatique");
		assessmentResult.setIdAssessmentResult(1);
		assessmentResult.setScore(16);
		assessmentResult.setStatus(true);
		
		assessmentResultDao.insert(assessmentResult);
	}
	
}
