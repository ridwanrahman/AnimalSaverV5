/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.restful;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ridwanurrahman
 */
@Entity
@Table(name = "ANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a")
    , @NamedQuery(name = "Animal.findByAnimalId", query = "SELECT a FROM Animal a WHERE a.animalId = :animalId")
    , @NamedQuery(name = "Animal.findByAnimalcolor", query = "SELECT a FROM Animal a WHERE a.animalcolor = :animalcolor")
    , @NamedQuery(name = "Animal.findByAnimalDesc", query = "SELECT a FROM Animal a WHERE a.animalDesc = :animalDesc")
    , @NamedQuery(name = "Animal.findByAnimalimage", query = "SELECT a FROM Animal a WHERE a.animalimage = :animalimage")
    , @NamedQuery(name = "Animal.findByAnimalName", query = "SELECT a FROM Animal a WHERE a.animalName = :animalName")
    , @NamedQuery(name = "Animal.findByWikilink", query = "SELECT a FROM Animal a WHERE a.wikilink = :wikilink")
    , @NamedQuery(name = "Animal.findByPostcode", query = "SELECT a FROM Animal a WHERE a.postcode = :postcode")
    , @NamedQuery(name = "Animal.findByState", query = "SELECT a FROM Animal a WHERE a.state = :state")
    , @NamedQuery(name = "Animal.findByStreetAddress", query = "SELECT a FROM Animal a WHERE a.streetAddress = :streetAddress")
    , @NamedQuery(name = "Animal.findByStreetNumber", query = "SELECT a FROM Animal a WHERE a.streetNumber = :streetNumber")
    , @NamedQuery(name = "Animal.findBySuburb", query = "SELECT a FROM Animal a WHERE a.suburb = :suburb")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIMAL_ID")
    private Integer animalId;
    @Size(max = 255)
    @Column(name = "ANIMALCOLOR")
    private String animalcolor;
    @Size(max = 2000)
    @Column(name = "ANIMAL_DESC")
    private String animalDesc;
    @Size(max = 255)
    @Column(name = "ANIMALIMAGE")
    private String animalimage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ANIMAL_NAME")
    private String animalName;
    @Size(max = 255)
    @Column(name = "WIKILINK")
    private String wikilink;
    @Size(max = 255)
    @Column(name = "POSTCODE")
    private String postcode;
    @Size(max = 255)
    @Column(name = "STATE")
    private String state;
    @Size(max = 255)
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Size(max = 255)
    @Column(name = "STREET_NUMBER")
    private String streetNumber;
    @Size(max = 255)
    @Column(name = "SUBURB")
    private String suburb;
    @JoinColumn(name = "ANIMALFAMILY_ANIMAL_FAMILY_ID", referencedColumnName = "ANIMAL_FAMILY_ID")
    @ManyToOne
    private AnimalFamily animalfamilyAnimalFamilyId;

    public Animal() {
    }

    public Animal(Integer animalId) {
        this.animalId = animalId;
    }

    public Animal(Integer animalId, String animalName) {
        this.animalId = animalId;
        this.animalName = animalName;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getAnimalcolor() {
        return animalcolor;
    }

    public void setAnimalcolor(String animalcolor) {
        this.animalcolor = animalcolor;
    }

    public String getAnimalDesc() {
        return animalDesc;
    }

    public void setAnimalDesc(String animalDesc) {
        this.animalDesc = animalDesc;
    }

    public String getAnimalimage() {
        return animalimage;
    }

    public void setAnimalimage(String animalimage) {
        this.animalimage = animalimage;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getWikilink() {
        return wikilink;
    }

    public void setWikilink(String wikilink) {
        this.wikilink = wikilink;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public AnimalFamily getAnimalfamilyAnimalFamilyId() {
        return animalfamilyAnimalFamilyId;
    }

    public void setAnimalfamilyAnimalFamilyId(AnimalFamily animalfamilyAnimalFamilyId) {
        this.animalfamilyAnimalFamilyId = animalfamilyAnimalFamilyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (animalId != null ? animalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.animalId == null && other.animalId != null) || (this.animalId != null && !this.animalId.equals(other.animalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AnimalSaverV5.restful.Animal[ animalId=" + animalId + " ]";
    }
    
}
