package com.company;

public class Customer {
    public String firstName;

    public String lastName;

    public String email;

    public Customer(String _firstName, String _lastName, String _email) {
        firstName = _firstName;
        lastName = _lastName;
        email = _email;

    }

    public String getCustomer() {
        String result = firstName + lastName + email;
        return result;
    }




}
