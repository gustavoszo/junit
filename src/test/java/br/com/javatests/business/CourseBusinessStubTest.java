package br.com.javatests.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.javatests.services.CourseService;
import br.com.javatests.services.stubs.CourseServiceStub;

class CourseBusinessStubTest {

	@Test
	void testRetrieveCoursesRelatedToSpring_When_UsingAStub() {
		// Given
		CourseService service = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(service);
				
		// When
		List<String> retrivedCourses = business.retriveCoursesRelatedToSpring("Gustavo");
		
		// Then
		assertEquals(2, retrivedCourses.size());
	}
	
	@Test
	void testRetrieveCoursesRelatedToSpring_When_UsingNome() {
		// Given
		CourseService service = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(service);
		
		// When
		List<String> retrivedCourses = business.retriveCoursesRelatedToSpring("Nome");
		
		// Then
		assertEquals(0, retrivedCourses.size());
	}

}
