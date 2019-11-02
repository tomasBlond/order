package com.switchfully.order.api.costumer.dto;

public class CostumerDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String Address;
    private int phoneNumber;

    public String getId() {
        return id;
    }

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

    public CostumerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CostumerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CostumerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public CostumerDto setAddress(String address) {
        Address = address;
        return this;
    }

    public CostumerDto setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CostumerDto setId(String id) {
        this.id = id;
        return this;
    }
}
