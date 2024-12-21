package com.bakheet.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String courseCodePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        courseCodePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid;
        if (code != null) {
            isValid = code.startsWith(courseCodePrefix);
        }else {
            isValid = true;
        }
        return isValid;
    }
}
