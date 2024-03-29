/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import AnimalSaverV5.mbeans.AnimalManagedBean;
import com.AnimalSaverV5.repository.entities.Animal;
import com.AnimalSaverV5.repository.entities.AnimalFamily;
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
    private ArrayList<AnimalFamily> animalFamilys;
    private ArrayList<Animal> animals2;

    public AnimalApplication() throws Exception {
        animals = new ArrayList<>();
        animalFamilys = new ArrayList<>();
        animals2 = new ArrayList<>();
                
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        animalManagedBean = (AnimalManagedBean)FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "animalManagedBean");
        //get animals from db
        updateAnimalList();
        updateAnimalFamilyList();
//        refeshList();
        System.out.println("COnstructor");
        System.out.println(animals);
    }

    public ArrayList<Animal> getAnimals() {
        refeshList();
        return this.animals;
    }
    
    public ArrayList<Animal> getAnimalsSecondFunction() {
//        refeshList();
//        System.out.println("herere");
        return this.animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<AnimalFamily> getAnimalFamilys() {
        return animalFamilys;
    }

    public void setAnimalFamilys(ArrayList<AnimalFamily> animalFamilys) {
        this.animalFamilys = animalFamilys;
    }
    
    public void searchAnimalById(int id) throws Exception {
        animals.clear();
        animals.add(animalManagedBean.searchAnimalById(id));
    }
    
    public void searchAnimalByFamilyId(int id, String state) throws Exception {
        System.out.println(id);
        System.out.println(state);
        this.updateAnimalList();
        ArrayList<Animal> newList = new ArrayList<>(animals);   
        animals.clear();
        animals2.clear();
//        System.out.println(newList);
        for(Animal ani: newList)
        {
            
            if(ani.getAnimalFamily() == null && ani.getLocation() == null) 
            {
//                System.out.println("null famly");
            }
            else if (ani.getAnimalFamily() != null && ani.getLocation() != null)
            {
//                System.out.println("***");
//                System.out.println(ani.getAnimalName());
//                System.out.println(ani.getAnimalFamily().getAnimalFamilyID());
//                System.out.println(ani.getLocation().getState());
//                System.out.println("***");
                if(ani.getAnimalFamily().getAnimalFamilyID() == id && ani.getLocation().getState().equals(state))
                {
                    System.out.println("***");
                    System.out.println(ani.getAnimalName());
                    animals2.add(ani);
                    System.out.println("***");
                }
                //find location not nulls
            }
            else
            {
                
            }
        }
        System.out.println("qqq");
        for(Animal i:animals2)
        {
            System.out.println(i.getAnimalName());
        }
        System.out.println("qqq");
        
//        animals.clear();
        setAnimals(animals2);
    }
    
    public void updateAnimalFamilyList() {
        if(animalFamilys != null && animalFamilys.size() > 0) {
        } else {
            animalFamilys.clear();
            for(com.AnimalSaverV5.repository.entities.AnimalFamily animal: animalManagedBean.getAllAnimalFamily())
            {
                animalFamilys.add(animal);
            }
            setAnimalFamilys(animalFamilys);
        }
    }
    
    public void updateAnimalList() {
//        System.out.println("updateing");
        if(animals != null && animals.size() > 0) {
        } else {
            animals.clear();
            for(com.AnimalSaverV5.repository.entities.Animal animal: animalManagedBean.getAllAnimals())
            {
                animals.add(animal);
            }
            setAnimals(animals);
        }
    }
    
    public void refeshList() {
        animals.clear();
        for(com.AnimalSaverV5.repository.entities.Animal animal: animalManagedBean.getAllAnimals())
        {
            animals.add(animal);
        }
        setAnimals(animals);
    }
}
