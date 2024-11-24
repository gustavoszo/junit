package br.com.javatests.business;

import java.util.ArrayList;
import java.util.List;

import br.com.javatests.services.CourseService;

public class CourseBusiness {
	
	private CourseService service;
	
	public CourseBusiness(CourseService service) {
		this.service = service;
	}
	
	public List<String> retriveCoursesRelatedToSpring(String student) {
		
		List<String> filteredCourses = new ArrayList<String>();
		if (student.equals("Nome")) return filteredCourses;
		
		List<String> allCourses = new ArrayList<String>(service.retrieveCourses(student));
		
		for (String course : allCourses) {
			if (course.contains("Spring")) {
				filteredCourses.add(course);
			}
		}
		
		return filteredCourses;
		
	}
	
	public void deleteCoursesRelatedToSpring(String student) {
		
		List<String> allCourses = new ArrayList<String>(service.retrieveCourses(student));
		
		for (String course : allCourses) {
			if (!course.contains("Spring")) {
				service.deleteCourse(course);
			}
		}
		
	}
	
}
