/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.mbeans;


import com.AnimalSaverV5.repository.AnimalRepository;
import com.AnimalSaverV5.repository.entities.Animal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
}
