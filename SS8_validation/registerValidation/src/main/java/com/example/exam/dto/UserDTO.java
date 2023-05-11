package com.example.exam.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
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
    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "10 digit phone number")
    private String phoneNumber;
    @NotNull
    @Email
    private String email;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;
        int dateBirth = user.getDateOfBirth().getYear();
        LocalDate now = LocalDate.now();
        int dateNow = now.getYear();
        int age = dateNow - dateBirth;
        ValidationUtils.rejectIfEmpty(errors, "dateBirth", "dateBirth.empty");
        if (age < 18) {
            errors.rejectValue("dateOfBirth", "dateOfBirth","age less than 18 years old");
        }
    }
}
