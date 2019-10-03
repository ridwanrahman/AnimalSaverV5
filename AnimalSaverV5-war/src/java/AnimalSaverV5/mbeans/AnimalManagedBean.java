/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.mbeans;


import com.AnimalSaverV5.repository.AnimalRepository;
import com.AnimalSaverV5.repository.entities.Animal;
import com.AnimalSaverV5.repository.entities.AnimalLocation;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ridwanurrahman
 */
@ManagedBean(name="animalManagedBean")
@SessionScoped
public class AnimalManagedBean implements Serializable{
    
    @EJB
    AnimalRepository animalRepository;

    public AnimalManagedBean() {
    }
    
    public List<Animal> getAllAnimals() {
        try {
            List<Animal> animals = animalRepository.getAllAnimal();
            return animals;
        } catch(Exception e) {
        }
        return null;
    }
    
    public void editAnimal(Animal animal) {
        try{
            System.out.println("saving edited animal");
            String s = animal.getLocation().getStreetNumber();
            AnimalLocation animalLocation = animal.getLocation();
            animalLocation.setStreetNumber(s);
            animal.setLocation(animalLocation);
            animalRepository.editAnimal(animal);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Animal has been updated succesfully"));
        } catch(Exception e) {
              System.out.println(e);
        }
        System.out.println(animal);
    }
}
