/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.restful;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ridwanurrahman
 */
@Entity
@Table(name = "ANIMAL_FAMILY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnimalFamily.findAll", query = "SELECT a FROM AnimalFamily a")
    , @NamedQuery(name = "AnimalFamily.findByAnimalFamilyId", query = "SELECT a FROM AnimalFamily a WHERE a.animalFamilyId = :animalFamilyId")
    , @NamedQuery(name = "AnimalFamily.findByAnimalFamilyDesc", query = "SELECT a FROM AnimalFamily a WHERE a.animalFamilyDesc = :animalFamilyDesc")
    , @NamedQuery(name = "AnimalFamily.findByAnimalFamilyName", query = "SELECT a FROM AnimalFamily a WHERE a.animalFamilyName = :animalFamilyName")})
public class AnimalFamily implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIMAL_FAMILY_ID")
    private Integer animalFamilyId;
    @Size(max = 255)
    @Column(name = "ANIMAL_FAMILY_DESC")
    private String animalFamilyDesc;
    @Size(max = 255)
    @Column(name = "ANIMAL_FAMILY_NAME")
    private String animalFamilyName;
    @OneToMany(mappedBy = "animalfamilyAnimalFamilyId")
    private Collection<Animal> animalCollection;

    public AnimalFamily() {
    }

    public AnimalFamily(Integer animalFamilyId) {
        this.animalFamilyId = animalFamilyId;
    }

    public Integer getAnimalFamilyId() {
        return animalFamilyId;
    }

    public void setAnimalFamilyId(Integer animalFamilyId) {
        this.animalFamilyId = animalFamilyId;
    }

    public String getAnimalFamilyDesc() {
        return animalFamilyDesc;
    }

    public void setAnimalFamilyDesc(String animalFamilyDesc) {
        this.animalFamilyDesc = animalFamilyDesc;
    }

    public String getAnimalFamilyName() {
        return animalFamilyName;
    }

    public void setAnimalFamilyName(String animalFamilyName) {
        this.animalFamilyName = animalFamilyName;
    }

    @XmlTransient
    public Collection<Animal> getAnimalCollection() {
        return animalCollection;
    }

    public void setAnimalCollection(Collection<Animal> animalCollection) {
        this.animalCollection = animalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (animalFamilyId != null ? animalFamilyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimalFamily)) {
            return false;
        }
        AnimalFamily other = (AnimalFamily) object;
        if ((this.animalFamilyId == null && other.animalFamilyId != null) || (this.animalFamilyId != null && !this.animalFamilyId.equals(other.animalFamilyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AnimalSaverV5.restful.AnimalFamily[ animalFamilyId=" + animalFamilyId + " ]";
    }
    
}
