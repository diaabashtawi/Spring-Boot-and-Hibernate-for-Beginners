package com.bakheet.deya.dao.impl;

import com.bakheet.deya.dao.AppDAO;
import com.bakheet.deya.entities.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }
}
