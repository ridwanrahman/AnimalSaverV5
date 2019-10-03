/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import com.AnimalSaverV5.repository.entities.AnimalFamily;
import com.AnimalSaverV5.repository.entities.AnimalLocation;
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
@Named(value = "animal")
public class Animal implements Serializable {
    
    private int animalId;
    private String animalName;
    private String animalDesc;
    private String animalColor;
    private String animalImage;
    private String wikiLink;
    
    private AnimalLocation animalLocation;
    private AnimalFamily animalFamily;
    
    private HashSet<String> tags;
    
    private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String state;
    
    private int animalFamilyID;
    private String animalFamilyName;
    private String animalFamilyDesc;
    
    private Set<com.AnimalSaverV5.repository.entities.Animal> animals;

    public Animal() {
        this.tags = new HashSet<>();
    }

    public Animal(int animalId, String animalName, String animalDesc, String animalColor, String animalImage, String wikiLink) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalDesc = animalDesc;
        this.animalColor = animalColor;
        this.animalImage = animalImage;
        this.wikiLink = wikiLink;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalDesc() {
        return animalDesc;
    }

    public void setAnimalDesc(String animalDesc) {
        this.animalDesc = animalDesc;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public String getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public AnimalLocation getAnimalLocation() {
        return animalLocation;
    }

    public void setAnimalLocation(AnimalLocation animalLocation) {
        this.animalLocation = animalLocation;
    }

    public AnimalFamily getAnimalFamily() {
        return animalFamily;
    }

    public void setAnimalFamily(AnimalFamily animalFamily) {
        this.animalFamily = animalFamily;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

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

    public Set<com.AnimalSaverV5.repository.entities.Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<com.AnimalSaverV5.repository.entities.Animal> animals) {
        this.animals = animals;
    }

}
