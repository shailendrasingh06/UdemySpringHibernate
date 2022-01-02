package com.example.springmvcdemo.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (null != s && s.length() != 0) {
            if (s.startsWith("LUV"))
                return true;
        }
        return false;
    }
}
