package com.bakheet.deya.repository.impl;

import com.bakheet.deya.repository.InstructorDetailRepository;
import com.bakheet.deya.entities.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@AllArgsConstructor
@Repository
public class InstructorDetailRepositoryImpl implements InstructorDetailRepository {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void saveAll(List<InstructorDetail> instructorDetailList) {
        for (InstructorDetail instructorDetail : instructorDetailList) {
            entityManager.persist(instructorDetail);
        }
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = findInstructorDetailById(id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }
}
