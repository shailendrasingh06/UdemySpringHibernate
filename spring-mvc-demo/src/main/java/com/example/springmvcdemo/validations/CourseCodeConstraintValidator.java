package com.example.springmvcdemo.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;
    @Override
    public void initialize(CourseCode theCourseCode) {
        ConstraintValidator.super.initialize(theCourseCode);
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (null != s && s.length() != 0) {
            if (s.startsWith(coursePrefix))
                return true;
        }
        return false;
    }
}
