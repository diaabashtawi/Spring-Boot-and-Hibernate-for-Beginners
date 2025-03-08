package com.bakheet.deya;

import com.bakheet.deya.repository.CourseRepository;
import com.bakheet.deya.repository.InstructorDetailRepository;
import com.bakheet.deya.repository.InstructorRepository;
import com.bakheet.deya.entities.*;
import com.bakheet.deya.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaHibernateAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateAdvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			InstructorRepository instructorRepository,
			InstructorDetailRepository instructorDetailRepository,
			CourseRepository courseRepository,
			StudentRepository studentRepository
	) {
		return runner-> {
			/*
			createInstructore(instructorRepository);
			findInstructor(instructorRepository);
			deleteInstructor(instructorRepository);
			findInstructorDetail(instructorDetailRepository);
			deleteInstructorDetail(instructorDetailRepository);
			createInstructoreWithCourses(instructorRepository, instructorDetailRepository);
			findInstructorWithCourses(instructorRepository);
			findCoursesForInstructor(instructorRepository, courseRepository);
			findInstructorWithCoursesJoinFetch(instructorRepository);
			updateInstructor(instructorRepository);
			updateCourse(courseRepository);
			deleteInstructor(instructorRepository);
			deleteCourse(courseRepository);
			createCourseAndReview(courseRepository);
			retrieveCoursesAndReviews(courseRepository);
			deleteCourseAndReviews(courseRepository);
			createCourseAndStuents(courseRepository);
			findCourseAndStudents(courseRepository);
			findStudentAndCourses(studentRepository);
			addMoreCourseForStudent(studentRepository);
			 */
			deleteStudent(studentRepository);





		};
	}

	private void deleteStudent(StudentRepository studentRepository) {
		System.out.println("Deleting student");
		studentRepository.deleteStudentById(2);
		System.out.println("Deleted student successfully");
	}

	private void addMoreCourseForStudent(StudentRepository studentRepository) {
		Student student = studentRepository.findStudentAndCoursesByStudentId(2);
		Course courseOne = new Course("How to Speed Cube");
		Course courseTwo = new Course("Game Design");
		student.addCourse(courseOne);
		student.addCourse(courseTwo);
		System.out.println("Updating student : " + student);
		System.out.println("Associated course : " + student.getCourses());
		studentRepository.updateStudent(student);
		System.out.println("Done!.");
	}

	private void findStudentAndCourses(StudentRepository studentRepository) {
		Student student = studentRepository.findStudentAndCoursesByStudentId(2);
		System.out.println("Loaded student: " + student);
		System.out.println("Found courses: " + student.getCourses());
		System.out.println("Done!.");
	}

	private void findCourseAndStudents(CourseRepository courseRepository) {
		Course course = courseRepository.findCourseAndStudentsByCourseId(5);
		System.out.println("Loaded courese : " + course);
		System.out.println("Loaded students : " + course.getStudents());
		System.out.println("Done!.");
	}

	private void createCourseAndStuents(CourseRepository courseRepository) {
		Course course = new Course("Spring Boot and Hibernate Advanced Application");
		Student firstStudent = new Student("John", "Doe", "john@doe.com");
		Student secondStudent = new Student("Mary", "Public", "mary@public.com");

		course.addStudent(firstStudent);
		course.addStudent(secondStudent);

		System.out.println("Saving course " + course);
		System.out.println("Saving student " + course.getStudents());

		courseRepository.saveCourse(course);
		System.out.println("Course created successfully");
	}

	private void deleteCourseAndReviews(CourseRepository courseRepository) {
		System.out.println("Deleting Course and Reviews");
		courseRepository.deleteCourseById(4);
		System.out.println("Coures and Reviews deleted successfully");
	}

	private void retrieveCoursesAndReviews(CourseRepository courseRepository) {
		Course course = courseRepository.findCourseAndReviewByCourseId(4);
		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void createCourseAndReview(CourseRepository courseRepository) {
		Course course = new Course("Spring Boot and Hibernate Advanced");
		course.addReview(new Review("Greate course I loved!"));
		course.addReview(new Review("Cool course, job well done"));
		course.addReview(new Review("Amazing course!!"));
		System.out.println("Saving course: " );
		System.out.println(course);
		System.out.println(course.getReviews());
		courseRepository.saveCourse(course);
		System.out.println("Courese Created Successfully");
	}

	private void deleteCourse(CourseRepository courseRepository) {
		System.out.println("Deleting course...");
		courseRepository.deleteCourseById(1);
		System.out.println("Course deleted!");
	}

	private void updateCourse(CourseRepository courseRepository) {
		System.out.println("Updating course");
		Course course = courseRepository.findCourseById(2);
		course.setTitle("Java Hibernate");
		courseRepository.updateCourse(course);
		System.out.println("Updated course");
	}

	private void updateInstructor(InstructorRepository instructorRepository) {
		System.out.println("Instructor updated");
		Instructor instructor = instructorRepository.findInstructorById(3);
		instructor.setFirstName("John");
		instructor.setLastName("Smith");
		instructorRepository.updateInstructor(instructor);
		System.out.println("Instructor updated");
	}


	private void findInstructorWithCoursesJoinFetch(InstructorRepository instructorRepository) {
		System.out.println("Finding Instructor with Courses Join Fetch : ");
		Instructor instructor = instructorRepository.findInstructorByIdJoinFetch(3);
		System.out.println("Found Instructor with Courses Join Fetch : " + instructor);
		System.out.println("The associated courses : " + instructor.getCourses());
		System.out.println("Done!.");
	}

	private void findCoursesForInstructor(InstructorRepository instructorRepository, CourseRepository courseRepository) {
		System.out.println("Finding instructor : ");
		Instructor instructor = instructorRepository.findInstructorById(3);
		System.out.println("Found instructor : " + instructor);
		System.out.println("Finding courses for instructor : ");
		List<Course> courses = courseRepository.findCoursesByInstructorId(3);
		instructor.setCourses(courses);
		System.out.println("The associated courses for instructor : " + instructor.getCourses());
		System.out.println("Done!.");
	}

	private void findInstructorWithCourses(InstructorRepository instructorRepository) {
		System.out.println("Finding instructor with courses: ");
		Instructor instructor = instructorRepository.findInstructorById(3);
		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
		System.out.println("Done!.");
	}

	private void createInstructoreWithCourses(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository) {
		Instructor instructor = new Instructor(
				"Susan",
				"Public",
				"012120123",
				"suan@gmail.com"
		);

		InstructorDetail instructorDetail = new InstructorDetail(
				"https://www.youtube.com",
				"Video Games"
		);

		instructor.setInstructorDetail(instructorDetail);
		Course courseOne = new Course("Spring Boot");
		Course courseTwo = new Course("MERN Stack");

		instructor.add(courseOne);
		instructor.add(courseTwo);
		System.out.println("Saving instructor: " + instructor);
		System.out.println("The course has been created: " + instructor.getCourses());
		instructorRepository.save(instructor);
		System.out.println("Done!");

	}

	private void deleteInstructorDetail(InstructorDetailRepository instructorDetailRepository) {
		System.out.println("Deleting instructor detail : ");
		instructorDetailRepository.deleteInstructorDetailById(2);
		System.out.println("Instructor detail deleted successfully");
	}

	private void findInstructorDetail(InstructorDetailRepository instructorDetailRepository) {
		System.out.println("Find Instructor Detail");
		InstructorDetail instructorDetail = instructorDetailRepository.findInstructorDetailById(1);
		System.out.println(instructorDetail);
		System.out.println("Instructor Detail: " + instructorDetail);
		System.out.println("The associated Instructor : " + instructorDetail.getInstructor());
		System.out.println("Done!.");

	}

	private void deleteInstructor(InstructorRepository instructorRepository) {
		System.out.println("Deleting instructor...");
		instructorRepository.deleteInstructorById(3);
		System.out.println("Instructor deleted successfully");
	}

	private void findInstructor(InstructorRepository instructorRepository) {
		int instructorId = 1;
		System.out.println("Finding instructor ID: " + instructorId);
		Instructor instructor = instructorRepository.findInstructorById(instructorId);
		System.out.println("Instructor : " + instructor);
		System.out.println("Instructor Details : " + instructor.getInstructorDetail());
	}

	private void createInstructore(InstructorRepository instructorRepository) {
		InstructorDetail instructorDetail = new InstructorDetail(
				"youtube channle link",
				"Spring boot"
		);
		Instructor instructor = new Instructor(
				"Deya",
				"Bakheet",
				"+971585077897",
				"diaabashtawi@gmail.com"
		);
		/*
		* Create new Instructor and also will create
		* Instructore Detail object and save also
		* because of CascadeType.ALL
		* */
		instructor.setInstructorDetail(instructorDetail);
		instructorRepository.save(instructor);

	}

}
