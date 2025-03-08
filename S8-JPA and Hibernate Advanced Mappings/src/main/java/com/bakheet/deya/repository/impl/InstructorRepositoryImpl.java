package com.bakheet.deya.repository.impl;

import com.bakheet.deya.repository.InstructorRepository;
import com.bakheet.deya.entities.Course;
import com.bakheet.deya.entities.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class InstructorRepositoryImpl implements InstructorRepository {

    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    /*
    * This will also retrieve the InstructorDetails Object
    * Because the default behavior of @OneToOne fetch type
    * is Eager
    * */
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        List<Course> courses = instructor.getCourses();
        for (Course course : courses) {
            course.setInstructor(null);
        }
        entityManager.remove(entityManager.merge(instructor));
//        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void saveAll(List<Instructor> instructors) {
        for (Instructor instructor : instructors) {
            entityManager.merge(instructor);
        }
//        entityManager.persist(instructors);
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "+
                        "join fetch i.courses "+
                        "join fetch i.instructorDetail "+
                        "where i.id = :id", Instructor.class
        );
        query.setParameter("id", id);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }
}
