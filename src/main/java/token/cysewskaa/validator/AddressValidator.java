package token.cysewskaa.validator;

import org.apache.log4j.Logger;
import token.cysewskaa.entities.AddressEntity;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by cysewskaa on 2016-08-17.
 */

public class AddressValidator implements ConstraintValidator<AdressValidatorAnnotation, AddressEntity> {



    @Override
    public void initialize(AdressValidatorAnnotation adressValidatorAnnotation) {
    }

    @Override
    public boolean isValid(AddressEntity addressEntity, ConstraintValidatorContext constraintValidatorContext) {
       /// log.info("sss");
        if(addressEntity.getCity()!=null && addressEntity.getStreet()!=null && addressEntity.getNumber()!=null) {
           if(addressEntity.getCity().chars().allMatch(x -> Character.isLetter(x))) {
                return true;
            }
            else {
               return false;}
            }
        else if(addressEntity.getCity()==null && addressEntity.getStreet()==null && addressEntity.getNumber()==null) {
            return true;}
        else {
            return false;}

    }
}
