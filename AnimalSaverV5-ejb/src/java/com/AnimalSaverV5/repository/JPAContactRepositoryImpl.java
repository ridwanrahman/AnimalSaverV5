/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.Animal;
import com.AnimalSaverV5.repository.entities.Contact;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ridwanurrahman
 */
@Stateless
public class JPAContactRepositoryImpl implements ContactRepository {
    
    @PersistenceContext(unitName = "AnimalSaverV5-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addContact(Contact contact) throws Exception {
        List<Contact> contacts = entityManager.createNamedQuery(Contact.GET_ALL_QUERY_NAME).getResultList();
        contact.setContactAnimalId(contacts.get(0).getContactAnimalId() + 1);
        entityManager.persist(contact);
    }

    @Override
    public Animal searchContactById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Criteria API
    @Override
    public List<Contact> getAllContacts() throws Exception {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Contact.class);
        Root<Contact> p = query.from(Contact.class);
        query.select(p);
        List<Contact> contacts = entityManager.createQuery(query).getResultList();
        return contacts;
    }

    @Override
    public void removeContact(int contactId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editContact(Contact contact) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
