/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import AnimalSaverV5.mbeans.AnimalManagedBean;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ridwanurrahman
 */
@RequestScoped
@Named(value = "searchAnimal")
public class SearchAnimal {
    
    private Animal animal;
    AnimalApplication app;
    private int searchByInt;
    
    private String animalState;
    private String animalfam;
    
    private int searchByAnimalFamilyId;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public AnimalApplication getApp() {
        return app;
    }

    public void setApp(AnimalApplication app) {
        this.app = app;
    }

    public int getSearchByInt() {
        return searchByInt;
    }

    public void setSearchByInt(int searchByInt) {
        this.searchByInt = searchByInt;
    }

    public int getSearchByAnimalFamilyId() {
        return searchByAnimalFamilyId;
    }

    public void setSearchByAnimalFamilyId(int searchByAnimalFamilyId) {
        this.searchByAnimalFamilyId = searchByAnimalFamilyId;
    }

    // FOR combinational search starts
    public String getAnimalState() {
        return animalState;
    }

    public void setAnimalState(String animalState) {
        this.animalState = animalState;
    }

    public String getAnimalfam() {
        return animalfam;
    }

    public void setAnimalfam(String animalfam) {
        this.animalfam = animalfam;
    }
    // FOR combinational search ends
    
    

    public SearchAnimal() {
        ELContext eLContext = FacesContext.getCurrentInstance().getELContext();
        
        app = (AnimalApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(eLContext, null, "animalApplication");
        app.updateAnimalList();
    }
    
    public void searchAnimalById(int animalId) {
        try {
            app.searchAnimalById(animalId);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void searchAll() {
        try {
            app.refeshList();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void searchAnimalByCombination(String state, String fam) {
        if (state.equals("#") || fam.equals("#"))
        {
//            System.out.println("hererererere");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You didn't search properly"));
        }
        else {
            int result = Integer.parseInt(fam);
            try {
                app.searchAnimalByFamilyId(result, state);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
