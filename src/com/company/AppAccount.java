package com.company;

import java.io.FileWriter;

public class AppAccount {

    private String firstName;
    private String lastName;
    private String accountNumber;
    private String pin;


    private List<String> roles;

    public CustomerAccount() {

    }

    public CustomerAccount(String firstName, String lastName, String accountNumber, String pin, String roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.pin = pin;

        this.roles = new ArrayList<String>();
        if (roles != null) {
            for (String r : roles) {
                this.roles.add(r);
            }
        }
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


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    public EmployeeAccount() {

    }

    public EmployeeAccount(String fullName, String pin, String roles) {
        this.fullName = fullName;
        this.pin = pin;

        this.roles = new ArrayList<String>();
        if (roles != null) {
            for (String r : roles) {
                this.roles.add(r);
            }
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    public String getInitials() {
        String result = firstName.substring(0,1)  lastName.substring(0,1);
        return;
    }
    public int getNameLenght() {
        int result = firstName.length() + lastName.length();
        return result;

    }
    public int getFirstPin() {
        String lowerCaseFirstName = firstName.toLowerCase().charAt(1) - 96;
        int rsl = firstName.charAt(1);
        rsl -=96;
        System.out.println(rsl);
        return rsl;
    }

    public int getSecondPin() {
        String lowerCaseFirstName = lastName.toLowerCase().charAt(1) - 96;
        int rsl = lastName.charAt(1);
        rsl -=96;
        System.out.println(rsl);
        return rsl;


    }
    public int getFirstPin() {

        return firstName.toLowerCase().charAt(1)-96;
    }
    public int getSecondPin() {

        return lastName.toLowerCase().charAt(1)-96;
    }

    public static void accountName () {


        Customer c1 = new Customer("joe", "billy", "656@g.coom" );
        File file = new File(c1.getInitials() + "-" + c1.getNameLenght() + "-" + c1.getFirstPin() + "-" + c1.getSecondPin() + ".txt");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("Account name\t transaction type\t an\t example\n");
            writer.flush();
            writer.close();


        } catch (Exception e) {
            System.out.println("It didn't work");
        }




}
