/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.mbeans;

import AnimalSaverV5.controllers.ContactUs;
import com.AnimalSaverV5.repository.entities.Contact;
import com.AnimalSaverV5.repository.ContactRepository;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ridwanurrahman
 */
@ManagedBean(name = "contactUsManagedBean")
@RequestScoped
public class ContactUsManagedBean implements Serializable {
    
    @EJB
    ContactRepository contactRepository;

    public ContactUsManagedBean() {
    }
    
    public List<Contact> getAllContacts() {
        try {
            List<Contact> contacts = contactRepository.getAllContacts();
            return contacts;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void addContactUs(AnimalSaverV5.controllers.ContactUs newContact) {
        Contact contact = convertedContactUs(newContact);
        try {
            contactRepository.addContact(contact);
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public com.AnimalSaverV5.repository.entities.Contact convertedContactUs(AnimalSaverV5.controllers.ContactUs localContactUs) {
        Contact c = new Contact();
        c.setAnimalName(localContactUs.getAnimalName());
        c.setAnimalDesc(localContactUs.getAnimalDesc());
        c.setAnimalImage(localContactUs.getAnimalImage());
        c.setDate(localContactUs.getDate());
        c.setAmount(localContactUs.getAmount());
        c.setName(localContactUs.getName());
        c.setPhoneNumber(localContactUs.getPhoneNumber());
        c.setEmailAddress(localContactUs.getEmailAddress());
        return c;
    }
    
}