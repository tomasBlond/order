package com.switchfully.order.domain.costumer;

import java.util.Objects;
import java.util.UUID;

public class Costumer {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int phoneNumber;

    public Costumer(String firstName, String lastName, String email, String address, int phoneNumber) {
        this.id = lastName + firstName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
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
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Costumer)) return false;
        Costumer costumer = (Costumer) o;
        return id.equals(costumer.id) &&
                firstName.equals(costumer.firstName) &&
                lastName.equals(costumer.lastName) &&
                email.equals(costumer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
