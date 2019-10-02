/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import AnimalSaverV5.mbeans.AnimalManagedBean;
import com.AnimalSaverV5.repository.entities.Animal;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ridwanurrahman
 */
@Named(value = "animalApplication")
@ApplicationScoped

public class AnimalApplication {
    
    @ManagedProperty(value = "#{animalManagedBean}")
    AnimalManagedBean animalManagedBean;
    
    private ArrayList<Animal> animals;

    public AnimalApplication() throws Exception {
        animals = new ArrayList<>();
        
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        System.out.println("sfads");
        animalManagedBean = (AnimalManagedBean)FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "animalManagedBean");
        //get animals from db
        updateAnimalList();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
    
    public void updateAnimalList() {
        if(animals != null && animals.size() > 0) {
            
        } else {
            animals.clear();
            for(com.AnimalSaverV5.repository.entities.Animal animal: animalManagedBean.getAllAnimals())
            {
                animals.add(animal);
            }
            System.out.println(animals);
            setAnimals(animals);
        }
    }
}
