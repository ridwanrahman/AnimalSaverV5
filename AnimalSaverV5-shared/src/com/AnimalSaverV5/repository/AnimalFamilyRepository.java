/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.AnimalFamily;
import javax.ejb.Remote;

/**
 *
 * @author ridwanurrahman
 */
@Remote
public interface AnimalFamilyRepository {
    
    public void addAnimalFamily(AnimalFamily animalFamily) throws Exception;
    
}
