package com.company;

public class BankingAction {
    public static void AddCustomer(Customer customer) {
        System.out.println("Creating " + customer.firstName);
        System.out.println("Creating " + customer.lastName);

        // add in all the other parameters for a customer
    FileManager.AddCustomerToFile(customer);

       String savingsFile, currentFile;
            savingsFile = GenerateAccountName(customer) + ".savings.txt";
            currentFile = GenerateAccountName(customer) + ".current.txt";

            FileManager.CreteCustomerAccount(savingsFile);
            FileManager.CreteCustomerAccount(currentFile);
        //Then write the customer details out to the file

    }

    public static String GenerateAccountName(Customer customer) {
     /// up to you to write the overall logic
        String fullName = customer.firstName + customer.lastName;
        return customer.firstName + customer.lastName + "-" + fullName.length();

    }



    public static void DeleteCustomer() {


    }

    public static void CreateTransaction(BankingTransaction transaction) {
        System.out.println("creating transaction...");

    }

    public static void ListCustomers() {


    }

    public static void ListTransactionHistory() {

    }

    public static void Lodge() {


    }

    public static void Withdraw() {


    }


}
