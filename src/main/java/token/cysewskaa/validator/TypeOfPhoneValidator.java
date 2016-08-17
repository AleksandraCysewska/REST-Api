package token.cysewskaa.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by cysewskaa on 2016-08-12.
 */
@Documented
@Constraint(validatedBy = TypeOfPhoneValidatorImp.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeOfPhoneValidator {

    String message() default "Please provide a valid type of phone" +
            "accepted types are mobile or landline";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};


}
