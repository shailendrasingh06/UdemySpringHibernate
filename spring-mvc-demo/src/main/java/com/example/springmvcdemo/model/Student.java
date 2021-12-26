package com.example.springmvcdemo.model;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String email;
    private String pass;
    private String country;
    private String favouriteLang;
    private LinkedHashMap<String, String> countryOptions;
    private LinkedHashMap<String, String> languageOptions;


    public Student() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("IND", "INDIA");
        countryOptions.put("NEP", "NEPL");

        languageOptions = new LinkedHashMap<>();
        languageOptions.put("Java", "Java");
        languageOptions.put("Python", "python");

    }

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

    public String getFavouriteLang() {
        return favouriteLang;
    }

    public void setFavouriteLang(String favouriteLang) {
        this.favouriteLang = favouriteLang;
    }

    public LinkedHashMap<String, String> getLanguageOptions() {
        return languageOptions;
    }

    public void setLanguageOptions(LinkedHashMap<String, String> languageOptions) {
        this.languageOptions = languageOptions;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", coding lang='" + favouriteLang + '\'' +
                '}';
    }
}
