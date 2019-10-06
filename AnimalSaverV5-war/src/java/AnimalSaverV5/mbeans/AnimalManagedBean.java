/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.mbeans;


import com.AnimalSaverV5.repository.AnimalRepository;
import com.AnimalSaverV5.repository.entities.Animal;
import com.AnimalSaverV5.repository.entities.AnimalFamily;
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
    
    public List<com.AnimalSaverV5.repository.entities.AnimalFamily> getAllAnimalFamily() {
        try {
            List<AnimalFamily> animalFamilys = animalRepository.getAllAnimalFamily();
            System.out.println(animalFamilys);
            return animalFamilys;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void addAnimal(AnimalSaverV5.controllers.Animal unconvertedAnimal) {
        Animal animal = convertToAnimal(unconvertedAnimal);
        System.out.println(animal);
        System.out.println("saving");
        try {
            animalRepository.addAnimal(animal);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void removeAnimal(int animalId) {
        try {
            animalRepository.removeAnimal(animalId);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public Animal searchAnimalById(int id) {
        try {
            return animalRepository.searchAnimalById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    private Animal convertToAnimal(AnimalSaverV5.controllers.Animal localAnimal) {
        Animal animal = new Animal();
        String street_number = localAnimal.getStreetNumber();
        String street_address = localAnimal.getStreetAddress();
        String suburb = localAnimal.getSuburb();
        String postcode = localAnimal.getPostcode();
        String state = localAnimal.getState();
        AnimalLocation location = new AnimalLocation(street_number,street_address,suburb,postcode,state);
        animal.setLocation(location);
        animal.setAnimalName(localAnimal.getAnimalName());
        animal.setAnimalDesc(localAnimal.getAnimalDesc());
        animal.setAnimalColor(localAnimal.getAnimalColor());
        animal.setAnimalImage(localAnimal.getAnimalImage());
        animal.setWikiLink(localAnimal.getWikiLink());
        try {            
            animal.setAnimalFamily(animalRepository.getAnimalFamilyByID(localAnimal.getAnimalFamilyID()));
        } catch (Exception e) {
            System.out.println(e);
        }
        return animal;
    }
    
    public void editAnimal(Animal animal) {
        try{
            String s = animal.getLocation().getStreetNumber();
            AnimalLocation animalLocation = animal.getLocation();
            animalLocation.setStreetNumber(s);
            animal.setLocation(animalLocation);
            animalRepository.editAnimal(animal);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Animal has been updated succesfully"));
        } catch(Exception e) {
              System.out.println(e);
        }
    }
}
