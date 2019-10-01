/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers.admin;

import AnimalSaverV5.mbeans.UserManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ridwanurrahman
 */
@Named(value = "userController")
@RequestScoped
public class userController implements Serializable{
    
    @ManagedProperty(value = "#{userManagedBean}")
    UserManagedBean userManagedBean;
    
    private int userId;
    
    private com.AnimalSaverV5.repository.entities.Users user;
    
    public userController() throws Exception {
        userId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("userId"));
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "userManagedBean");
        user = getUser();
    }        
    
    public int getUserId() {
        return 4343;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public com.AnimalSaverV5.repository.entities.Users getUser() throws Exception{
        int id = userId-1;
        return userManagedBean.getAllUsers().get(id);
    }
    
    public void logout() throws Exception {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);
        session.invalidate();
    }
}