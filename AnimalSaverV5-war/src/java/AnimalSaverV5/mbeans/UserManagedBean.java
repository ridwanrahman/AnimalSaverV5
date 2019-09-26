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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


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
    
    public void addUser(Users user) {
        System.out.println("user");
        try{
            userRepository.addUsers(user);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void editUser(Users user) {
        try {
            System.out.println(user);
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
