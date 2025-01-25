package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourceAndStudents(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addMoreCoursesForStudent(appDAO);
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting student id: " + theId);
		appDAO.deleteStudentById(theId);
		System.out.println("DONE!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 13;
		System.out.println("Deleting course id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("DONE!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		// create more courses
		Course tempCourse1 = new Course("Basic JS!!");
		Course tempCourse2 = new Course("PHP");
		Course tempCourse3 = new Course("C++");

		// add courses to the student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		tempStudent.addCourse(tempCourse3);

		System.out.println("Update Student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Loaded student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());
		System.out.println("!DONE!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("Loaded Course: " + tempCourse);
		System.out.println("Students : " + tempCourse.getStudents());
		System.out.println("!Done!");
	}

	private void createCourceAndStudents(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Java");

		// create the student
		Student tempStudent1 = new Student("Rajesh", "Nahak", "raj@luv2code.com");
		Student tempStudent2 = new Student("rahul", "Choudhary", "rahul@luv2code.com");

		// add student to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("associated student: " + tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("!Done!");
	}

}
