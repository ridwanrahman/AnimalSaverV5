/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ridwanurrahman
 */
@Entity
@Table(name = "ANIMAL_FAMILY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = AnimalFamily.GET_ALL_QUERY_NAME, query = "SELECT af FROM AnimalFamily af")})

public class AnimalFamily implements Serializable{
    
    public static final String GET_ALL_QUERY_NAME = "AnimalFamily.getAll";
    
    private int animalFamilyID;
    private String animalFamilyName;
    private String animalFamilyDesc;
    
    private Set<Animal> animals;

    public AnimalFamily() {
    }

    public AnimalFamily(int animalFamilyID, String animalFamilyName, String animalFamilyDesc) {
        this.animalFamilyID = animalFamilyID;
        this.animalFamilyName = animalFamilyName;
        this.animalFamilyDesc = animalFamilyDesc;
        this.animals = new HashSet<>();
    }

    @Id
    @GeneratedValue
    @Column(name = "animal_family_ID")
    public int getAnimalFamilyID() {
        return animalFamilyID;
    }

    public void setAnimalFamilyID(int animalFamilyID) {
        this.animalFamilyID = animalFamilyID;
    }

    @Column(name = "animal_family_name")
    public String getAnimalFamilyName() {
        return animalFamilyName;
    }

    public void setAnimalFamilyName(String animalFamilyName) {
        this.animalFamilyName = animalFamilyName;
    }

    @Column(name = "animal_family_desc")
    public String getAnimalFamilyDesc() {
        return animalFamilyDesc;
    }

    public void setAnimalFamilyDesc(String animalFamilyDesc) {
        this.animalFamilyDesc = animalFamilyDesc;
    }

    @OneToMany(mappedBy = "animalFamily")    
    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    
    
}