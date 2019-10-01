/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.Animal;
import javax.ejb.Remote;

/**
 *
 * @author ridwanurrahman
 */
@Remote
public interface AnimalRepository {
    
    public void addAnimal(Animal animal) throws Exception;
    
    
    
    
}
