/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import com.AnimalSaverV5.repository.entities.Contact;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ridwanurrahman
 */
@RequestScoped
@Named(value = "contactUs")
public class ContactUs implements Serializable {
    
    public enum Status { EXTINCT, ENDANGERED, NORMAL};
    
    private int contactAnimalId;
    private String animalName;
    private String animalDesc;
//    @Enumerated(EnumType.STRING)
    private Contact.Status status;
//    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private Time time;
    private int amount;
    private String longitude;
    private String latitude;
    private String animalImage;
    private String name;
    private String contactNumber;
    private String emailAddress;
    private String phoneNumber;

    public ContactUs() {
    }

    public ContactUs(int contactAnimalId, String animalName, String animalDesc, Contact.Status status, Date date, Time time, int amount, String longitude, String latitude, String animalImage, String name, String contactNumber, String emailAddress, String phoneNumber) {
        this.contactAnimalId = contactAnimalId;
        this.animalName = animalName;
        this.animalDesc = animalDesc;
        this.status = status;
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.longitude = longitude;
        this.latitude = latitude;
        this.animalImage = animalImage;
        this.name = name;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public int getContactAnimalId() {
        return contactAnimalId;
    }

    public void setContactAnimalId(int contactAnimalId) {
        this.contactAnimalId = contactAnimalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalDesc() {
        return animalDesc;
    }

    public void setAnimalDesc(String animalDesc) {
        this.animalDesc = animalDesc;
    }

    public Contact.Status getStatus() {
        return status;
    }

    public void setStatus(Contact.Status status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
