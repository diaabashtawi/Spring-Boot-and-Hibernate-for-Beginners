package com.bakheet.deya.repository.impl;

import com.bakheet.deya.entities.Course;
import com.bakheet.deya.entities.Student;
import com.bakheet.deya.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManager entityManager;


    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s join fetch s.courses where s.id = :id", Student.class
        );
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student deletedStudent = entityManager.find(Student.class, id);
        if (deletedStudent != null) {
            List<Course> courses = deletedStudent.getCourses();
            for (Course course : courses) {
                course.getStudents().remove(deletedStudent);
            }
            entityManager.remove(deletedStudent);
        }
    }
}
