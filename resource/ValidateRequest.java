package net.skyscanner.halo.megastorm.api.rest.validate;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class ValidateRequest {

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private ValidateRequest() {}

    public static <T> String validate(T t) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            sb.append(constraintViolation.getMessage());
        }
        return sb.toString();
    }
}
