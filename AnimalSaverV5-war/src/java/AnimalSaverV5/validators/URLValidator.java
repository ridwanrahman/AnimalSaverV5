/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimalSaverV5.validators;

import static AnimalSaverV5.validators.EmailValidator.urlValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@FacesValidator(value = "urlValidator")
public class URLValidator implements Validator {
    private static final String URL_REGEX ="^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
			"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
			"([).!';/?:,][[:blank:]])?$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    
    public static boolean urlValidator(String url) {
        if (url == null) {
            return false;
        }
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        StringBuilder url = new StringBuilder();
        String urlValue = value.toString();
        if (urlValidator(urlValue)) {
        } else {
            context = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("URL validation failed (Format should include https)","Invalid URL format");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(component.getClientId(), msg);
        }
    }
}
