package com.company;

import java.util.Scanner;

public class MenuBuilder {
    //Greeting and first screen with options
    private static int startMenu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("***************************");
        System.out.println("           WELCOME!        ");
        System.out.println(" Choose from these choices ");
        System.out.println("***************************");
        System.out.println("1 - Bank Employee Login");
        System.out.println("2 - Customer Login");
        System.out.println("0 - Quit");
        System.out.print("Enter Your option: ");


        selection = input.nextInt();
        return selection;

    }

    //Menu for customers
    private static int customerMenu() {
        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("____________________\n");
        System.out.println("1 - Login");
        System.out.println("2 - Lodge");
        System.out.println("3 - Withdraw");
        System.out.println("4 - Transaction History");
        System.out.println("0 - Quit");
        System.out.print("Enter Your option: ");


        selection = input.nextInt();
        return selection;

    }

    private static Customer AddCustomerForm() {
        Scanner myObj = new Scanner(System.in); // create a scanner object
        System.out.println("Enter First Name");

        String firstName = myObj.nextLine(); //read users input
        System.out.println("First name is: " + firstName); //output user input

        System.out.println("Enter Last Name");
        String lastName = myObj.nextLine();
        System.out.println("Last name is: " + lastName);

        System.out.println("Enter Your Email");
        String email = myObj.nextLine();
        System.out.println("Email is: " + email);


        //  validate here...

        Customer customer = new Customer(firstName, lastName, email);

        System.out.println("New customer created: " + firstName + lastName);
        return customer;


    }


    private static int transactionMenu() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("________________________\n");
        System.out.println("1 - Lodge Money");
        System.out.println("2 - Withdraw Money");
        System.out.println("0 - Quit");
        System.out.print("Enter Your option: ");

        selection = input.nextInt();
        return selection;


    }

    private static BankingTransaction CreateTransactionLodgeForm() {
        System.out.println("Transaction lodge form goes here");
        double balance;
        double previousTransaction;
        double amount;
        BankingTransactionLodge btl = new BankingTransactionLodge();
       /*  {
            if (amount != 0) {
                balance = balance + amount;
                previousTransaction = amount;
            }
        }*/
        return btl;

    }

    private static BankingTransaction CreateTransactionWithdrawForm() {
        double balance;
        double previousTransaction;
        System.out.println("Transaction withdraw form goes here");

        BankingTransactionWithdraw btw = new BankingTransactionWithdraw();
      /*  void withdraw(int amount) {
            if (amount != 0) {
                balance = balance - amount;
                previousTransaction = - amount;
            }
        }*/
        return btw;

    }

    private static void DeleteCustomer() {
        ArrayList<Customer> cats = new ArrayList<>();
        Customer ip = new Customer ("Ivan", "Petrov", "45@gmail.com" );
        Customer rk = new Customer ("Ron", "Kell", "454@gmail.com");
        Customer jf = new Customer ("John", "Fall", "54@gmail.com");
        Customer rb = new Customer ("Roy", "Black", "984@gmail.com");

        customers.add(ip);
        customers.add(rk);
        customers.add(jf);
        customers.add(rb);
        System.out.println(customers.toString());

        Iterator<Customer> customerIterator = customers.iterator();
//create iterator

        while(customerIterator.hasNext()) {
//check condition


            Customer nextCustomer = customerIterator.next();


            if (nextCustomer.fulname.equals("Ivan Petrov")) {
                customerIterator.remove();
//delete person how was looking for

            }
        }

        System.out.println(customers);



    }

    private static int bankingMenu() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("___________________\n");
        System.out.println("1 - Add Customer");
        System.out.println("2 - Delete Customer");
        System.out.println("3 - Create Transaction");
        System.out.println("4 - List of Customers");
        System.out.println("0 - Quit");
        System.out.print("Enter Your option: ");


        selection = input.nextInt();
        return selection;

    }

    private static String getBankEmployeePin() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter you PIN");

        String pin = myObj.nextLine();
        System.out.println("PIN is: " + pin);

        return pin;

    }

    private static String getCustomerPin() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter you PIN");

        String pin = myObj.nextLine();
        System.out.println("PIN is: " + pin);


    }

    public static void Run() {
        int userChoice = MenuBuilder.startMenu();

        switch (userChoice) {
            case 0:
                System.out.println("Thank you for using our application");
                System.exit(0);
                break;

            case 1:
                //get the banking pin from employee
                String pin = getBankEmployeePin();
                SecurityBanking sb = new SecurityBanking();
                boolean isAuthenticated = sb.login(pin);

                // logic of Authentification for Employee

                int counter = 3;
                int attempt = 3;
                char[] pin = 'A123';
                Console c=System.console();
                System.out.println("Enter PIN: ");
                pin = c.readPassword();
                String pass = String.valueOf(pin);
                if(pass.equals("A123")){
                    System.out.println("Correct PIN entered!");
                }
                while(!pass.equals("A123") && attempt != 0){
                    System.out.println("Invalid PIN entered!. Attempts remaining. " + --attempt);
                    counter--;
                    if(attempt != 0){
                        c = System.console();
                        System.out.println("Enter PIN: ");
                        pin = c.readPassword();
                        pass = String.valueOf(pin);
                        if(pass.equals("A123")){
                            System.out.println("Correct PIN entered!");
                        }
                    }
                    else{
                        System.out.println("Please contact support");
                        break;
                    }
                }



                if (isAuthenticated) {

                    int bankEmployeeAction = MenuBuilder.bankingMenu();


                    switch (bankEmployeeAction) {

                        case AppConstants.CUSTOMER_CREATE:
                            Customer newCustomer = AddCustomerForm();
                            BankingAction.AddCustomer(newCustomer);
                            break;

                        case AppConstants.TRANSACTION_CREATE:
                            int transactionChoice = MenuBuilder.transactionMenu();

                            switch (transactionChoice) {

                                case AppConstants.TRANSACTION_LODGE:
                                    BankingTransaction btl = CreateTransactionLodgeForm();
                                    BankingAction.CreateTransaction(btl);
                                    break;

                                case AppConstants.TRANSACTION_WITHDRAW:
                                    BankingTransaction btw = CreateTransactionWithdrawForm();
                                    BankingAction.CreateTransaction(btw);
                                    break;

                            }


                        case AppConstants.CUSTOMER_LIST:
                            System.out.println("listing customers");
                            FileManager.ListCustomers();
                            break;

                    }


                } else {
                    System.out.println("Authentication error.");
                    return;
                }

            case 2:
                //get the Customer pin
                String pin = getCustomerPin();
                SecurityBanking sb = new SecurityBanking();
                boolean isAuthenticated = sb.login(pin);

                //add logic here if is Authenticated








                if (isAuthenticated) {

                    int bankCustomerAction = MenuBuilder.customerMenu();


                    switch (bankCustomerAction) {

                        case 0:
                            System.out.println("Thank you for using our application");
                            System.exit(0);
                            break;

                        case AppConstants.TRANSACTION_CREATE:
                            int transactionChoice = MenuBuilder.transactionMenu();

                            switch (transactionChoice) {

                                case AppConstants.TRANSACTION_LODGE:
                                    BankingTransaction btl = CreateTransactionLodgeForm();
                                    BankingAction.CreateTransaction(btl);
                                    break;

                                case AppConstants.TRANSACTION_WITHDRAW:
                                    BankingTransaction btw = CreateTransactionWithdrawForm();
                                    BankingAction.CreateTransaction(btw);
                                    break;

                            }


                        case AppConstants.CUSTOMER_TRANSACTION_HISTORY:
                            System.out.println("History of yours transactions");
                            FileManager.TransactionHistory();
                            break;


                    }


                     } else {
                    System.out.println("Unknown error has occured");
                      return;
                     }



                }

        }
    }

