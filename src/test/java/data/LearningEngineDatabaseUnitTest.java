package data;


import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.talsoft.learningengine.data.LearningEngineDatabase;
import com.talsoft.learningengine.domain.Assessment;
import com.talsoft.learningengine.domain.AssessmentResult;
import com.talsoft.learningengine.domain.Course;

public class LearningEngineDatabaseUnitTest {
	
	@Before
	public void initialiser() {
	}
	
	@Test
	public void test_getAllCourses() {
		List<Course> coursesList = LearningEngineDatabase.getAllCourses();
		Assert.assertEquals(coursesList.size(), 4);
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
		Assert.assertTrue(LearningEngineDatabase.getAllCourses().contains(course));
		
		LearningEngineDatabase.getMyCourses().remove(course);
	}
	
	@Test
	//Il n'y a pas de cours suivis par défaut
	public void test_getMyCourses() {
		List<Course> coursesList = LearningEngineDatabase.getMyCourses();
		Assert.assertTrue(coursesList.size() == 0);
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
		
		LearningEngineDatabase.getMyAssessmentResults().remove(assessmentResult);
	}
	
	@Test
	public void test_getMyAssessmentResults() {
		List<AssessmentResult> myAssessmentResultList = LearningEngineDatabase.getMyAssessmentResults();
		Assert.assertTrue(myAssessmentResultList.size() == 3);
	}
	
	@Test
	public void test_getMyAssessments() {
		List<Assessment> assessmentList = LearningEngineDatabase.getMyAssessments();
		Assert.assertTrue(assessmentList.size() == 3);
	}
	
	@Test
	public void test_addAssessment() {
		Assessment assessment = new Assessment();
		assessment.setDateOfAssessment(new DateTime("04072014"));
		assessment.setDuration(1);
		assessment.setIdAssessment(1);
		assessment.setTitle("Automates et langage C !");
		
		LearningEngineDatabase.addAssessment(assessment);
		Assert.assertTrue(LearningEngineDatabase.getMyAssessments().contains(assessment));
		
		LearningEngineDatabase.getMyAssessments().remove(assessment);
	}
}
