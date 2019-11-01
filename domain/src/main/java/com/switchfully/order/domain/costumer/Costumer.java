package com.switchfully.order.domain.costumer;

import java.util.UUID;

public class Costumer {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String Address;
    private int phoneNumber;

    public Costumer(String firstName, String lastName, String email, String address, int phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        Address = address;
        this.phoneNumber = phoneNumber;
    }

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
}
