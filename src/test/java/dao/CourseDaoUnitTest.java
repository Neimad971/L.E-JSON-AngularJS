package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.talsoft.learningengine.data.LearningEngineDatabase;
import com.talsoft.learningengine.domain.Course;

public class CourseDaoUnitTest {
	
	@Before
	public void initialiser() {
	}

	@Test
	public void test_findAll() {
		List<Course> coursesList = LearningEngineDatabase.getAllCourses();
		Assert.assertTrue(coursesList.size() > 0);
	}
	
	@Test
	public void test_insert() {
		Course course = new Course();
		course.setIdCourse(1);
		course.setName("Mathématiques");
		course.setOnline(true);
		course.setValidated(true);
		course.setFollowed(true);
		
		LearningEngineDatabase.addMyCourse(course);
		Assert.assertTrue(LearningEngineDatabase.getMyCourses().contains(course));
	}
}
