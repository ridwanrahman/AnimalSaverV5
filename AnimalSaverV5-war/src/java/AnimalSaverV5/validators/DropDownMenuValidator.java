/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author ridwanurrahman
 */
@FacesValidator(value = "dropDownMenuValidator")
public class DropDownMenuValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        StringBuilder str = new StringBuilder();
        String strValue = value.toString();
        if(strValue.equals("#")) {
            context = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("You have not made a selection from the dropdown menus","Invalid URL format");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(component.getClientId(), msg);
        } else {
        }
    }
    
    
}
