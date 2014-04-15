package user.mgt.ui.bean.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "user.mgt.ui.bean.validator.NullValidator")
public class NullValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent ui, Object obj)
			throws ValidatorException {
		if (obj == null || obj.toString() == null) {
			FacesMessage msg = new FacesMessage("Value cannot be null");
			throw new ValidatorException(msg);
		}
	}

}
