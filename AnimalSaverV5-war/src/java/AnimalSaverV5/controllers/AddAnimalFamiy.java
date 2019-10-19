/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import AnimalSaverV5.mbeans.AnimalManagedBean;
import java.io.Serializable;
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
@Named("addAnimalFamily")
public class AddAnimalFamiy implements Serializable{
    
    @ManagedProperty(value = "#{animalManagedBean}")
    AnimalManagedBean animalManagedBean;
    
    private AnimalFamily animalFamily;
    AnimalApplication app;

    public AnimalFamily getAnimalFamily() {
        return animalFamily;
    }

    public void setAnimalFamily(AnimalFamily animalFamily) {
        this.animalFamily = animalFamily;
    }
    
    public AddAnimalFamiy() {
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
    
    public void addAnimalFamily(AnimalFamily unconvertedAnimalFamily) {
        try {
            animalManagedBean.addAnimalFamily(unconvertedAnimalFamily);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Animal family has been saved successfully"));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
