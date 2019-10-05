/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AnimalSaverV5.repository;

import com.AnimalSaverV5.repository.entities.Animal;
import com.AnimalSaverV5.repository.entities.Contact;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ridwanurrahman
 */
@Remote
public interface ContactRepository {
    
    public void addContact(Contact contact) throws Exception;
    public Animal searchContactById(int id) throws Exception;
    public List<Contact> getAllContacts() throws Exception;
    public void removeContact(int contactId) throws Exception;
    public void editContact(Contact contact) throws Exception;
    
}
