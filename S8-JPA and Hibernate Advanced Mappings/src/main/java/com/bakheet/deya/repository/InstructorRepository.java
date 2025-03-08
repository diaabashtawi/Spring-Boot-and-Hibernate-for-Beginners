package com.bakheet.deya.repository;

import com.bakheet.deya.entities.Instructor;

import java.util.List;

public interface InstructorRepository {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    void saveAll(List<Instructor> instructors);
    Instructor findInstructorByIdJoinFetch(int id);
    void updateInstructor(Instructor instructor);
}
