package com.fpt.taxcalculator.model;

import jakarta.validation.constraints.NotNull;

public class SearchPersonRequest {
    @NotNull(message = "Please provide first name")
    private String firstName;

    @NotNull(message = "Please provide last name")
    private String lastName;

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
}
