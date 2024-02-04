package mrodriguezdev.me.apitodomate.infraestructure.utils;

import jakarta.validation.ConstraintViolation;
import mrodriguezdev.me.apitodomate.domain.exceptions.BadRequestException;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidationUtil {
    public static <T> void validar(T objeto) {
        Set<ConstraintViolation<T>> violations  = BeanValidator.validate(objeto);

        if (!violations.isEmpty()) {
            String errorMessages = violations.stream()
                    .map(violation -> String.format("%s: %s", violation.getPropertyPath(), violation.getMessage()))
                    .collect(Collectors.joining(", "));
            throw new BadRequestException(String.format("Validation failed. Issues found: %s", errorMessages ));
        }
    }
}
