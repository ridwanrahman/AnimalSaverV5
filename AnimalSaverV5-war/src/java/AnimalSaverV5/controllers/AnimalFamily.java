/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ridwanurrahman
 */
@RequestScoped
@Named(value = "animalFamily")
public class AnimalFamily implements Serializable{
    
    private int animalFamilyID;
    private String animalFamilyName;
    private String animalFamilyDesc;
    
    private HashSet<String> tags;

    public AnimalFamily() {
    }

    public AnimalFamily(int animalFamilyID, String animalFamilyName, String animalFamilyDesc, HashSet<String> tags) {
        this.animalFamilyID = animalFamilyID;
        this.animalFamilyName = animalFamilyName;
        this.animalFamilyDesc = animalFamilyDesc;
        this.tags = tags;
    }
    
//    private Set<com.AnimalSaverV5.repository.entities.Animal> animals;
    private Set<com.AnimalSaverV5.repository.entities.AnimalFamily> animalFamilys;

    public int getAnimalFamilyID() {
        return animalFamilyID;
    }

    public void setAnimalFamilyID(int animalFamilyID) {
        this.animalFamilyID = animalFamilyID;
    }

    public String getAnimalFamilyName() {
        return animalFamilyName;
    }

    public void setAnimalFamilyName(String animalFamilyName) {
        this.animalFamilyName = animalFamilyName;
    }

    public String getAnimalFamilyDesc() {
        return animalFamilyDesc;
    }

    public void setAnimalFamilyDesc(String animalFamilyDesc) {
        this.animalFamilyDesc = animalFamilyDesc;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    public Set<com.AnimalSaverV5.repository.entities.AnimalFamily> getAnimalFamilys() {
        return animalFamilys;
    }

    public void setAnimalFamilys(Set<com.AnimalSaverV5.repository.entities.AnimalFamily> animalFamilys) {
        this.animalFamilys = animalFamilys;
    }
}
