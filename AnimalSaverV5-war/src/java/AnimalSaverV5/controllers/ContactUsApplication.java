/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import AnimalSaverV5.mbeans.ContactUsManagedBean;
import com.AnimalSaverV5.repository.entities.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ridwanurrahman
 */
@Named(value = "contactUsApplication")
@ApplicationScoped
public class ContactUsApplication {
    
    @ManagedProperty(value = "#{contactUsManagedBean}")
    ContactUsManagedBean contactUsManagedBean;
    
    private ArrayList<Contact> contactUsPeople;

    public ContactUsApplication() {
        System.out.println("jjjjjj");
        contactUsPeople = new ArrayList<>();
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        contactUsManagedBean = (ContactUsManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
                .getValue(elContext, null, "contactUsManagedBean");
        updateContactUsList();
    }

    public ArrayList<Contact> getContactUsPeople() {
        return contactUsPeople;
    }

    public void setContactUsPeople(ArrayList<Contact> contactUsPeople) {
        this.contactUsPeople = contactUsPeople;
    }
    
    public void updateContactUsList() {
        if(contactUsPeople!=null && contactUsPeople.size()>0) {
            
        } else {
            contactUsPeople.clear();
            for(com.AnimalSaverV5.repository.entities.Contact c:contactUsManagedBean.getAllContacts())
            {
                contactUsPeople.add(c);
            }
            
            System.out.println(contactUsPeople);
            setContactUsPeople(contactUsPeople);
        }
    }
}
