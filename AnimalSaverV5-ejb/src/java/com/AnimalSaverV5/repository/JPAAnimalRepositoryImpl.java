/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.Animal;
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
public class JPAAnimalRepositoryImpl implements AnimalRepository{
    
    @PersistenceContext(unitName = "AnimalSaverV5-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addAnimal(Animal animal) throws Exception {
        System.out.println("****saving animal to database****");
        List<Animal> animals = entityManager.createNamedQuery(Animal.GET_ALL_QUERY_NAME).getResultList();
        System.out.println(animals.get(0).getAnimalId() + 1);
        animal.setAnimalId(animals.get(0).getAnimalId() + 1);
        entityManager.persist(animal);
    }

    @Override
    public Animal searchAnimalById(int id) throws Exception {
        System.out.println("Search animal by id");
        Animal animal = entityManager.find(Animal.class, id);
        animal.getTags();
        System.out.println(animal);
        return animal;
    }

    @Override
    public List<Animal> getAllAnimal() throws Exception {
        return entityManager.createNamedQuery(Animal.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public List<Animal> getAllAnimalFamilyList() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAnimal(int animalId) throws Exception {
        System.out.println("Remove animal ejb");
        Animal animal = this.searchAnimalById(animalId);
        if(animal != null) {
            System.out.println("removing animal");
            entityManager.remove(animal);
        }
    }

    @Override
    public void editAnimal(Animal animal) throws Exception {
        try {
            entityManager.merge(animal);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<AnimalFamily> getAllAnimalFamily() throws Exception {
        try {
            return entityManager.createNamedQuery(AnimalFamily.GET_ALL_QUERY_NAME).getResultList();
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public AnimalFamily getAnimalFamilyByID(int id) throws Exception {
        AnimalFamily animalFamily = entityManager.find(AnimalFamily.class, id);
        return animalFamily;
    }
}
