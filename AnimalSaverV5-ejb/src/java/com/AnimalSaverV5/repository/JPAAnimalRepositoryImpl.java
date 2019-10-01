/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.Animal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ridwanurrahman
 */
public class JPAAnimalRepositoryImpl implements AnimalRepository{
    
    @PersistenceContext(unitName = "AnimalSaverV5-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addAnimal(Animal animal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
