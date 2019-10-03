/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.Animal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ridwanurrahman
 */
@Stateless
public class JPAAnimalRepositoryImpl implements AnimalRepository{
    
    @PersistenceContext(unitName = "AnimalSaverV5-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addAnimal(Animal animal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Animal searchAnimalById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Animal> getAllAnimal() throws Exception {
        System.out.println("getting all animal");
        return entityManager.createNamedQuery(Animal.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public List<Animal> getAllAnimalFamilyList() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAnimal(int animalId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editAnimal(Animal animal) throws Exception {
        try {
            System.out.println("saving edited animal");
            entityManager.merge(animal);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    
    
    
}
