package com.company;

public class DataBase {

    private static final Map<String, EmployeeAccount> mapUsers = new HashMap<String, EmployeeAccount>();

    static {
        initUsers();
    }

    private static void initUsers() {

        // for Employee
        EmployeeAccount emp = new EmployeeAccount("Ivan Petrov", "A123", SecurityConfig.ROLE_EMPLOYEE);


        mapUsers.put(emp.getFullName(), emp.getPin);

        // Find a Employee by fullName and pin.
        public static EmployeeAccount findUser (String fullName, String pin){
            EmployeeAccount u = mapUsers.get(fullName);
            if (u != null && u.getPin().equals(pin)) {
                return u;
            }
            return null;
        }

        private static final Map<String, CustomerAccount> mapUsers = new HashMap<String, CustomerAccount>();

        static {
            initUsers();
        }

        private static void initUsers () {

            // for Customer
            CustomerAccount cust = new CustomerAccount("Ivan", "Petrove", "123", "jb-45-12", SecurityConfig.ROLE_CUSTOMER);


            mapUsers.put(cust.getFirstName(), cust.getLastName, cust.getAccountNomber, cust.getPin);

        }

        // Find a Customer details and pin.
        public static CustomerAccount findUser (String firstName, String lastName, String accountNumber, String
        pin, String roles){
            CustomerAccount u = mapUsers.get(firstName, lastName, accountNumber);
            if (u != null && u.getPin().equals(pin)) {
                return u;
            }
            return null;
        }
    }
}
