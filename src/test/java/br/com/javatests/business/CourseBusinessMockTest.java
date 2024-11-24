package br.com.javatests.business;

// import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import br.com.javatests.services.CourseService;

class CourseBusinessMockTest {
	
	private CourseService service;
	private CourseBusiness business;
	private List<String> courses;
	
	@BeforeEach
	void setup() {
		// Given
		service = mock(CourseService.class);
		business = new CourseBusiness(service);
		courses = Arrays.asList("Docker", "CI/CD", "Java", "API Rest com Spring Boot 3", "Spring Boot e MVC");
	}

	@Test
	void testRetrieveCoursesRelatedToSpring_When_UsingAMock() {
		// Given
		given(service.retrieveCourses("Gustavo")).willReturn(courses);
				
		// When
		List<String> retrivedCourses = business.retriveCoursesRelatedToSpring("Gustavo");
		
		// Then
		assertThat(retrivedCourses.size(), is(2));
	}
	
	@DisplayName("Test DeleteCourse Not Related To Spring Using Mockito Verify")
	@Test
	void testDeleteCourseNotRelatedToSpring_ShouldCallMethodDeleteCourse() {
		// Given
		given(service.retrieveCourses("Gustavo")).willReturn(courses);
		
		// When
		business.deleteCoursesRelatedToSpring("Gustavo");
			
		// Then
		verify(service).deleteCourse("Docker");
		// verify(service, times(1)).deleteCourse("Docker");
		// verify(service, atLeast(1)).deleteCourse("Docker");
		verify(service, never()).deleteCourse("Spring Boot e MVC");
	}
	
	@DisplayName("Test DeleteCourse Not Related To Spring Using Mockito Verify V2")
	@Test
	void testDeleteCourseNotRelatedToSpring_ShouldCallMethodDeleteCourseV2() {
		// Given
		given(service.retrieveCourses("Gustavo")).willReturn(courses);
		
		// When
		business.deleteCoursesRelatedToSpring("Gustavo");
		
		// Then
		then(service)
			.should()
			.deleteCourse("Docker");
		
		then(service)
			.should(never())
			.deleteCourse("Spring Boot e MVC");
	}
	
	@DisplayName("Test DeleteCourse Not Related To Spring Using ArgumentCapture")
	@Test
	void testDeleteCourseNotRelatedToSpring_UsingArgumentCapture() {
		// Given
		courses = Arrays.asList("Docker", "Spring Boot e MVC", "CI/CD");
		given(service.retrieveCourses("Gustavo")).willReturn(courses);
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		
		// When
		business.deleteCoursesRelatedToSpring("Gustavo");
		
		// Then
		then(service)
		.should(times(2))
		.deleteCourse(argumentCaptor.capture());
		
		assertThat(argumentCaptor.getAllValues().size(), is(2));
	}

}
