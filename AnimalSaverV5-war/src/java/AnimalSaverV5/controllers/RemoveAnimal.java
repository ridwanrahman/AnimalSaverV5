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
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ridwanurrahman
 */
@RequestScoped
@Named("removeAnimal")
public class RemoveAnimal {
    
    @ManagedProperty(value = "#{animalManagedBean}")
    AnimalManagedBean animalManagedBean;
    
    private Animal animal;
    AnimalApplication app;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public RemoveAnimal() {        
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        app = (AnimalApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "animalApplication");
        app.updateAnimalList();
        
        //instantiate animalManagedBean
        ELContext eLContext = FacesContext.getCurrentInstance().getELContext();
        animalManagedBean = (AnimalManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(eLContext, null, "animalManagedBean");
        //instantiate propertyManagedBean
    }
    
    public void removeAnimal(int id) {
        try {
            animalManagedBean.removeAnimal(id);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Animal has been deleted succesfully"));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    
}
