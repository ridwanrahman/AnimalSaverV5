/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ridwanurrahman
 */
@Stateless
public class JPAUserRepositoryImpl implements UserRepository{
    
    @PersistenceContext(unitName = "AnimalSaverV5-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addUsers(Users user) throws Exception {
        List<Users> users = entityManager.createNamedQuery("Users.findAll").getResultList();
        int i=users.size() + 1;
        Long l= new Long(i);
        user.setId(l);
        entityManager.persist(user);
    }

    @Override
    public List<Users> getAllUsers() throws Exception {
        return entityManager.createNamedQuery("Users.findAll").getResultList();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users searchUsersById(long id) throws Exception {
        Users user = entityManager.find(Users.class, id);
        return user;
        
    }

    @Override
    public void removeUsers(int id) throws Exception {
        Users user = this.searchUsersById(id);
        if(user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void editUsers(Users user) throws Exception {
        try {
            entityManager.merge(user);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
