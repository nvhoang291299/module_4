package com.example.exam.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.util.Date;


public class UserDTO implements Validator {

    @NotNull
    @NotEmpty(message = "field is empty")
    @Size(min = 5, max = 45)
    private String firstName;
    @NotNull
    @NotEmpty(message = "field is empty")
    @Size(min = 5, max = 45)
    private String lastName;
    @Pattern(regexp = "^\\d{10}$", message = "10 digit phone number")
    private String phoneNumber;
    @NotNull
    @Min(value = 18)
    @Max(value = 100)
    private int age;
    @Email
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    public UserDTO() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
