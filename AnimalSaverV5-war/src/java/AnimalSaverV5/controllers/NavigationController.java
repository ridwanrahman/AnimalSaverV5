/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author ridwanurrahman
 */
@ManagedBean(name="navigationController")
@RequestScoped
public class NavigationController implements Serializable{
    
    @ManagedProperty(value = "#{param.pageId}")
    private String pageId = "1";
    
    public String showPage() {
        if(pageId == null) {
            return "index";
        }
        if(pageId.equals("1")) {
            return "index";
        } else if(pageId.equals("2")) {
            return "about";
        } else if(pageId.equals("3")) {
            return "imageGallery";
        } else if(pageId.equals("4")) {
            return "contact";
        } else {
            return "index";
        }
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
}
