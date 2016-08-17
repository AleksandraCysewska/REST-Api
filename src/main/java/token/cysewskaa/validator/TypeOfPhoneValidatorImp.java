package token.cysewskaa.validator;

import token.cysewskaa.entities.PersonEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by cysewskaa on 2016-08-12.
 */
public class TypeOfPhoneValidatorImp implements ConstraintValidator<TypeOfPhoneValidator, PersonEntity> {
    @Override
    public void initialize(TypeOfPhoneValidator typeOfPhoneValidator) {
    }


    @Override
    public boolean isValid(PersonEntity personEntity, ConstraintValidatorContext constraintValidatorContext) {
        if (personEntity.getTypeOfPhone() == null && personEntity.getPhone() == null)
            return true;
       else if (personEntity.getTypeOfPhone().equals(TypeOfPhone.LANDLINE) ||  personEntity.getTypeOfPhone().equals(TypeOfPhone.MOBILE) )

            return true;
         else
            return false;

    }
}
