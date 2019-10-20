/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers.admin;

import AnimalSaverV5.mbeans.UserManagedBean;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ridwanurrahman
 */
@RequestScoped
@Named(value = "removeUser")
public class RemoveUser {
    
    private int userId;
    
    @ManagedProperty(value = "#{userManagedBean}")
    UserManagedBean userManagedBean;

    public RemoveUser() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "userManagedBean");
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void removeUser(int id) {
        try {
//            System.out.println(id);
            userManagedBean.removeUser(id);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
}
