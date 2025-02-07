package com.bakheet.deya;

import com.bakheet.deya.dao.AppDAO;
import com.bakheet.deya.entities.Instructor;
import com.bakheet.deya.entities.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaHibernateAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateAdvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner-> {
			createInstructore(appDAO);
		};
	}

	private void createInstructore(AppDAO appDAO) {
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
		appDAO.save(instructor);

	}

}
