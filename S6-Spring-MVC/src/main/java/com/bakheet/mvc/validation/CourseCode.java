package com.bakheet.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({
        ElementType.METHOD,
        ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    public String value() default "DXB";
    public String message() default "Invalid Course Code, must start with DXB";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
