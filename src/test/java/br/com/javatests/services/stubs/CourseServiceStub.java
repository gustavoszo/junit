package br.com.javatests.services.stubs;

import java.util.Arrays;
import java.util.List;

import br.com.javatests.services.CourseService;

public class CourseServiceStub implements CourseService {

	@Override
	public List<String> retrieveCourses(String student) {
		return Arrays.asList("Docker", "CI/CD", "Java", "API Rest com Spring Boot 3", "Spring Boot e MVC");
	}

	@Override
	public void deleteCourse(String course) {
		// TODO Auto-generated method stub
		
	}

}
