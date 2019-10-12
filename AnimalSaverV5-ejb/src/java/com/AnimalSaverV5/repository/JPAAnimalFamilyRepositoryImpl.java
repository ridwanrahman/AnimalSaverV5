/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.AnimalFamily;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ridwanurrahman
 */
@Stateless
public class JPAAnimalFamilyRepositoryImpl implements AnimalFamilyRepository{
    
    @PersistenceContext(unitName = "AnimalSaverV5-ejbPU")
    private EntityManager entityManager;


    @Override
    public void addAnimalFamily(AnimalFamily data) throws Exception {
        List<AnimalFamily> animalFam = entityManager.createNamedQuery("AnimalFamily.getALLDESC").getResultList();
        data.setAnimalFamilyID(animalFam.get(0).getAnimalFamilyID() + 1);
        entityManager.persist(data);
    }
}
