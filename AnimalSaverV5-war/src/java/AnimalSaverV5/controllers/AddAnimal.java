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
@Named("addAnimal")
public class AddAnimal {
    
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
    
    public AddAnimal() {
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        app = (AnimalApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "animalApplication");
        app.refeshList();
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        animalManagedBean = (AnimalManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "animalManagedBean");
    }
    
    public void addAnimal(Animal unconvertedAnimal) {
        try {
            System.out.println("in add animal controller");
            animalManagedBean.addAnimal(unconvertedAnimal);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Animal has been saved successfully"));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
