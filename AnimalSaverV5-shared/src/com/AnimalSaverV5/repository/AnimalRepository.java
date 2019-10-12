/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.Animal;
import com.AnimalSaverV5.repository.entities.AnimalFamily;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ridwanurrahman
 */
@Remote
public interface AnimalRepository {
    
    public void addAnimal(Animal animal) throws Exception;
    public Animal searchAnimalById(int id) throws Exception;
    public List<Animal> getAllAnimal() throws Exception;
    public List<Animal> getAllAnimalFamilyList() throws Exception;
    public void removeAnimal(int animalId) throws Exception;
    public void editAnimal(Animal animal) throws Exception;
    public Animal searchAnimalByFamilyId(int id) throws Exception;
    
    public List<AnimalFamily> getAllAnimalFamily() throws Exception;
    public AnimalFamily getAnimalFamilyByID(int id) throws Exception;
    
    
}
