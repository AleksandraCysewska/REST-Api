package token.cysewskaa.validator;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by cysewskaa on 2016-08-17.
 */
@Documented
@Constraint(validatedBy = AddressValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdressValidatorAnnotation {

    String message() default "Please provide a valid address";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};


}
