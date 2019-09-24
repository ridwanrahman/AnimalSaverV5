/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers.admin;

import AnimalSaverV5.mbeans.UserManagedBean;
import com.AnimalSaverV5.repository.entities.Users;
import java.io.Serializable;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ridwanurrahman
 */
@Named(value = "addStaffBean")
@RequestScoped
public class addStaffBean implements Serializable{
    private String userName;
    private String password;
    private String userType;
    
    @ManagedProperty(value = "#{userManagedBean}")
    UserManagedBean userManagedBean;

    public addStaffBean() {
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "userManagedBean");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String confirmation() {
        Users user = new Users();
//        user.setId(12345678910L);
        String username = this.getUserName();
        String password = this.getPassword();
        String usertype = this.getUserType();
        user.setUsername(username);
        user.setPassword(password);
        user.setUsertype(usertype);
        try {
            userManagedBean.addUser(user);
        } catch (Exception e) {
            System.out.print(e);
        }
        return "confirmation.xhtml";
    }
}
