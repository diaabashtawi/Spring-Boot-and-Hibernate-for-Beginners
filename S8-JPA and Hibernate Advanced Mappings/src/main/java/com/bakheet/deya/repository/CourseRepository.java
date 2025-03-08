package com.bakheet.deya.repository;

import com.bakheet.deya.entities.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findCoursesByInstructorId(int id);
    Course findCourseById(int id);
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourseById(int id);
    Course findCourseAndReviewByCourseId(int id);
    Course findCourseAndStudentsByCourseId(int id);
}
