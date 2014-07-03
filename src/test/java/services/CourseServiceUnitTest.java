package services;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;

import com.talsoft.learningengine.dao.CourseDao;
import com.talsoft.learningengine.domain.Course;
import com.talsoft.learningengine.services.CourseService;

public class CourseServiceUnitTest {
	private CourseService courseService;
	private CourseDao mCourseDao;
	
	@Before
	public void initialiser() {
		courseService = new CourseService();
		mCourseDao = EasyMock.createMock(CourseDao.class);
	}
	
	@Ignore
	public void test_showAllCourses() {
		Course course = new Course();
		course.setIdCourse(1);
		course.setName("Mathématiques");
		course.setOnline(true);
		course.setValidated(true);
		course.setFollowed(true);
		
		List<Course> coursesList = new ArrayList<Course>();
		coursesList.add(course);
		EasyMock.expect(mCourseDao.findAll()).andReturn(coursesList);
		
		EasyMock.replay(mCourseDao);
		List<Course> coursesListExpected = courseService.showAllCourses();
		EasyMock.verify(mCourseDao);
		
		Assert.assertEquals(coursesList.size(), coursesListExpected.size());
		
	}
}
