package com.example.springmvcdemo.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define default value
    public String value() default "LUV";
    //define default error message
    public String message() default "Course code must start wih LUV";
    //defince default group
    public Class<?>[] groups() default {};
    //define default payloads (payloads provides custom details about the validation failure)
    public Class<? extends Payload>[] payload() default{};
}
