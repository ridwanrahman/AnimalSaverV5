/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.mbeans;

import com.AnimalSaverV5.repository.UserRepository;
import com.AnimalSaverV5.repository.entities.Users;
import javax.inject.Named;

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
@ManagedBean(name = "userManagedBean", eager = true)
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
    
    public boolean addUser(Users user) {
//        List<Users> people = getAllUsers();
//        System.out.println("&&&&&&&&");
        boolean exists = false;
        boolean done = false;
        for(Users people:getAllUsers())
        {
            System.out.println(people.getUsername());
            if(user.getUsername().equals(people.getUsername()))
            {
                exists = true;
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage message = new FacesMessage("Username exists");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, message);
            }
        }
        try{
            System.out.println(exists);
            if(exists == false) {                
                userRepository.addUsers(user);
                done = true;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return done;
    }
    public void editUser(Users user) {
        try {
//            System.out.println("^^^^^^^^");
//            System.out.println(user.getUsertype());
//            System.out.println(user);
            userRepository.editUsers(user);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void removeUser(int id) {
        try {
//            Long l= new Long(id);
            userRepository.removeUsers(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
