package org.bedu.java.backend.Postwork.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<GlobalInterface, String>{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //válida numeros positivos, no nulo y que no inicie en 0
        return value != null && (value.length()<3 || value.length()>50)&&value.matches("^[1-9]\\d*$\n");
    }
}
