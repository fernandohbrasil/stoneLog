package br.com.stones.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value = "cpfClienteValidator")
public class CpfClienteValidator extends AbstractValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String cpf = String.valueOf(o);
        
        if (daoFactory.getClienteDao().cpfExistente(cpf)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "CPF já cadastrado!"));
        }
    }
    
}
