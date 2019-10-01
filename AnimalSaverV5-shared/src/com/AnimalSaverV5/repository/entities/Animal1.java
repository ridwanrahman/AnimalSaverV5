/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ridwanurrahman
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Animal.GET_ALL_QUERY_NAME, query = "SELECT a FROM Animal a order by a.animalId desc")})

public class Animal1 implements Serializable{
    
    public static final String GET_ALL_QUERY_NAME = "Animal.getAll";
    
    private int animalId;
    private String animalName;
    @Size(min = 10, max = 2000)
    private String animalDesc;
    private String animalColor;
    private String animalImage;
    private String wikiLink;
    private AnimalLocation location;
   // private AnimalFamily family;
    
//    private Set<String> tags;

    public Animal1() {
//        this.tags = new HashSet<>();
    }

    public Animal1(int animalId, String animalName, String animalDesc, String animalColor, String animalImage, String wikiLink, AnimalLocation location) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalDesc = animalDesc;
        this.animalColor = animalColor;
        this.animalImage = animalImage;
        this.wikiLink = wikiLink;
        this.location = location;
        //this.family = family;
//        this.tags = tags;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "animal_id")
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Column(name = "animal_name")
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Column(name = "animal_desc")
    public String getAnimalDesc() {
        return animalDesc;
    }

    public void setAnimalDesc(String animalDesc) {
        this.animalDesc = animalDesc;
    }

    @Column(name = "animal_color")
    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    @Column(name = "animal_image")
    public String getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }

    @Column(name = "wikipedia_link")
    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    @Embedded
    public AnimalLocation getLocation() {
        return location;
    }

    public void setLocation(AnimalLocation location) {
        this.location = location;
    }
    
    //@ManyToOne
    //public AnimalFamily getFamily() {
    //    return family;
    //}

    //public void setFamily(AnimalFamily family) {
    //    this.family = family;
    //}
    
//    @ElementCollection
//    @CollectionTable(name = "tag")
//    @Column(name = "value")
//    public Set<String> getTags() {
//        return tags;
//    }
//
//    public void setTags(Set<String> tags) {
//        this.tags = tags;
//    }
}