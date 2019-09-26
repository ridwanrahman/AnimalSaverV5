/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ridwanurrahman
 */
@Remote
public interface UserRepository {
    
    public void addUsers(Users user) throws Exception;
    public List<Users> getAllUsers() throws Exception;
    public Users searchUsersById(long id) throws Exception;
    public void removeUsers(int id) throws Exception;
    public void editUsers(Users user) throws Exception;
    
}
