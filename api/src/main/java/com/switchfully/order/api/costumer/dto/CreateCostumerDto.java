package com.switchfully.order.api.costumer.dto;

public class CreateCostumerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String Address;
    private int phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return Address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public CreateCostumerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateCostumerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateCostumerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateCostumerDto setAddress(String address) {
        Address = address;
        return this;
    }

    public CreateCostumerDto setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
