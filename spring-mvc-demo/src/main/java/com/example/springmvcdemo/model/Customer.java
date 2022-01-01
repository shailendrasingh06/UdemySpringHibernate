package com.example.springmvcdemo.model;

import com.example.springmvcdemo.validations.CourseCode;

import javax.validation.constraints.*;
import java.util.LinkedHashMap;

public class Customer {
    private String firstName;
    @NotNull(message = "last name can not be null")
    @Size(min = 2, message = "last Name is required")
    private String lastName;
    private String email;
    private String pass;
    private String country;
    @NotNull(message = "is required")
    @Min(value = 18, message = "should not be less than 8")
    @Max(value = 65, message = "should be less than equal to 11")
    private Integer age;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 digits/characters")
    private String postalCode;
    @CourseCode(groups = Customer.class)
    private String courseCode;
    private LinkedHashMap<String, String> countryOptions;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
