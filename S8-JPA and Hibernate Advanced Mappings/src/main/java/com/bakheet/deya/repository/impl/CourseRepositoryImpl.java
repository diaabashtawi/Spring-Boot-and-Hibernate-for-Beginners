package com.bakheet.deya.repository.impl;

import com.bakheet.deya.repository.CourseRepository;
import com.bakheet.deya.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final EntityManager entityManager;

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> courseTypedQuery =
                entityManager.createQuery(
                        "from Course where instructor.id= :instructorId",
                        Course.class
                );
        courseTypedQuery.setParameter("instructorId", id);

        List<Course> courses = courseTypedQuery.getResultList();
        return courses;
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "join fetch c.reviews " +
                        "where c.id = :id", Course.class
        );
        query.setParameter("id", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        TypedQuery<Course> query =
                entityManager.createQuery(
                        "select c from Course c "
                        + "join fetch c.students "
                        + "where c.id = :id", Course.class
                );
        query.setParameter("id", id);
        Course course = query.getSingleResult();
        return course;
    }

}
