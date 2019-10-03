/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ridwanurrahman
 */
@Named(value = "animalController")
@RequestScoped
public class AnimalController {
    
    private int animalId;

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
    
    private com.AnimalSaverV5.repository.entities.Animal animal;    

    public AnimalController() {
        animalId = Integer.valueOf(FacesContext.
                getCurrentInstance().
                getExternalContext().
                getRequestParameterMap()
                .get("animalId"));
        animal = getAnimal();
    }
    
    public com.AnimalSaverV5.repository.entities.Animal getAnimal() {
        if(animal == null) {
            ELContext context = FacesContext.getCurrentInstance().getELContext();
            AnimalApplication app = (AnimalApplication) FacesContext.getCurrentInstance()
                                        .getApplication()
                                        .getELResolver()
                                        .getValue(context, null, "animalApplication");
            return app.getAnimals().get(--animalId);
        }
        return animal;
    }
}
