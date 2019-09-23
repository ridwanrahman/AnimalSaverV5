/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ridwanurrahman
 */
@Named(value = "aboutController")
@RequestScoped
public class AboutController {
    
    private String pageTitle;
    
    public AboutController() {
        pageTitle = "About page"
;    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
