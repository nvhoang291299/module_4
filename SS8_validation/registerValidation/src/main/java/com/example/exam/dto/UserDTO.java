package com.example.exam.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
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
    private String dateOfBirth;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;
        LocalDate dateBirth = null;
        LocalDate now = LocalDate.now();
        int dateNow = now.getYear();
        try {
            dateBirth = LocalDate.parse(user.dateOfBirth);
            Period age = Period.between(dateBirth, now);
            if (age.getYears() < 18) {
                errors.rejectValue("dateOfBirth", "dateOfBirth","age less than 18 years old");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
