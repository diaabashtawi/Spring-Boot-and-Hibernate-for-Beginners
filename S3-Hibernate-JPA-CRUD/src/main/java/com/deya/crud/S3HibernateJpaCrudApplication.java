package com.deya.crud;

import com.deya.crud.dao.StudentDao;
import com.deya.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class S3HibernateJpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3HibernateJpaCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner->{
			System.out.println("Coming from CommandLineRunner...");
			createNewStudent(studentDao);
//			readStudent(studentDao);
//			queryFromStudents(studentDao);
//			queryFromStudentsByLastName(studentDao);
//			updateStudent(studentDao);
//			deleteStudent(studentDao);
//			deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all students...");
		int numbersOfRowsDeleted = studentDao.deleteAll();
		System.out.println("Number of rows deleted: " + numbersOfRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		int id = 7004;
		System.out.println("Deleting student id :" + id);
		studentDao.delete(id);
	}

	private void updateStudent(StudentDao studentDao) {
		int id = 7004;
		System.out.println("Getting the student with id: " + id);
		Student student = studentDao.findById(id);
		System.out.println("Updating the student with id: " + id);
		student.setFirstName("Scooby");
		studentDao.update(student);
		System.out.println("The student with id: " + id + " has been updated");
		System.out.println("Updated student : " + student);

	}

	private void queryFromStudentsByLastName(StudentDao studentDao) {
		List<Student> students = studentDao.findByLastName("Bakheet");
		students.forEach(System.out::println);
	}

	private void queryFromStudents(StudentDao studentDao) {
		List<Student> students = studentDao.findAll();
		for(Student student : students) {
			System.out.println(student);
		}
	}


	private void readStudent(StudentDao studentDao) {
		Student student = new Student(
				"Daffy",
				"Duck",
				"duffy@gmail.com"
		);

		System.out.println("Saving the student.....");
		studentDao.save(student);
		int id = student.getId();
		System.out.println("Saved student. Generated ID : " + student.getId());
		System.out.println("Retrieved student : " + student.getId());
		Student student1 =  studentDao.findById(id);
		System.out.println("Retrieved student : " + student1);


	}

	private void createNewStudent(StudentDao studentDao) {
		Student student = new Student(
				"Daffy",
				"Duck",
				"duffy@gmail.com"
		);

		System.out.println("Saving the student.....");
		studentDao.save(student);
		System.out.println("Saved student. Generated ID : " + student.getId());
		System.out.println("Retrieved student : " + student.getId());



	}

}
