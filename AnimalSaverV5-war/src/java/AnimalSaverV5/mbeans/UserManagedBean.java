/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.mbeans;

import com.AnimalSaverV5.repository.UserRepository;
import com.AnimalSaverV5.repository.entities.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author ridwanurrahman
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {
    
    @EJB
    UserRepository userRepository;

    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    
    public List<Users> getAllUsers() {
        try {
            return userRepository.getAllUsers();
        } catch(Exception e) {
            
        }
        return null;
    }
    
}
