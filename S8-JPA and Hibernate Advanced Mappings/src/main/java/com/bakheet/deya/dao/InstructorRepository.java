package com.bakheet.deya.dao;

import com.bakheet.deya.entities.Instructor;

public interface InstructorDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
