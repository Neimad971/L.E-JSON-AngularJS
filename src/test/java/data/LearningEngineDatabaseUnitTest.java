package data;


import java.util.List;

import javassist.expr.Instanceof;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.talsoft.learningengine.data.LearningEngineDatabase;
import com.talsoft.learningengine.domain.AssessmentResult;
import com.talsoft.learningengine.domain.Course;

public class LearningEngineDatabaseUnitTest {
	
	@Before
	public void initialiser() {
	}
	
	@Test
	public void test_getAllCourses() {
		List<Course> coursesList = LearningEngineDatabase.getAllCourses();
		Assert.assertTrue(coursesList.size() > 0);
	}
	
	@Test
	public void test_addCourse() {
		Course course = new Course();
		course.setIdCourse(1);
		course.setName("Mathématiques");
		course.setOnline(true);
		course.setValidated(true);
		course.setFollowed(true);
		
		course.setDescription("Matrices, Ensembles, Logique");
		LearningEngineDatabase.addCourse(course);
	}
	
	@Test
	public void test_getMyCourses() {
		Course course = new Course();
		course.setIdCourse(1);
		course.setName("Mathématiques");
		course.setOnline(true);
		course.setValidated(true);
		course.setFollowed(true);
		
		LearningEngineDatabase.addMyCourse(course);
		List<Course> coursesList = LearningEngineDatabase.getMyCourses();
		Assert.assertEquals(coursesList.size(), 2);
	}
	
	@Test
	public void test_addAssessmentResults() {
		AssessmentResult assessmentResult = new AssessmentResult();
		assessmentResult.setAssessmentName("Histoire : début de l'ère informatique");
		assessmentResult.setIdAssessmentResult(1);
		assessmentResult.setScore(16);
		assessmentResult.setStatus(true);
		
		LearningEngineDatabase.addAssessmentResults(assessmentResult);
		Assert.assertTrue(LearningEngineDatabase.getMyAssessmentResults().contains(assessmentResult));
	}
	
	@Test
	public void test_getMyAssessmentResults() {
		List<AssessmentResult> myAssessmentResultList = LearningEngineDatabase.getMyAssessmentResults();
		Assert.assertTrue(myAssessmentResultList.size() > 0);
	}
}
