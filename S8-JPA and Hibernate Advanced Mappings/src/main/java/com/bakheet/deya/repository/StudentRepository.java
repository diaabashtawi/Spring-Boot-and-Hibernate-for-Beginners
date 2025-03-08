package com.bakheet.deya.repository;


import com.bakheet.deya.entities.Student;

public interface StudentRepository {

    Student findStudentAndCoursesByStudentId(int id);
    void updateStudent(Student student);
    void deleteStudentById(int id);
}
