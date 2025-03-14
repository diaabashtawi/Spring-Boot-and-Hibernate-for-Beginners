package com.bakheet.deya.repository;

import com.bakheet.deya.entities.InstructorDetail;

import java.util.List;

public interface InstructorDetailRepository {

    void saveAll(List<InstructorDetail> instructorDetailList);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
