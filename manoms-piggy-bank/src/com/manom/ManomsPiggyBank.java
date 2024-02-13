package com.manom;

import java.util.*;

public class ManomsPiggyBank implements Bank{

    private static final Map<Integer, String> adminMenu = new HashMap<>();
    private static final ArrayList<Customer> customerList = new ArrayList<>();
    private static final Scanner inputScanner = new Scanner(System.in).useDelimiter("\n");
    private static final Random accNumberGenerator = new Random();

    public void init(){
        int userInput = 0;
        final String banksBanner = Decorator.msgHeaderDecorator + "Bank Admin Menu" + Decorator.msgHeaderDecorator;
        while (userInput != 6) {
            System.out.println(banksBanner);
            showAdminMenu();
            try {
                System.out.print("Choose an action: ");
                userInput = inputScanner.nextInt();
                handleUserInput(userInput);
            } catch (Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private static void  showAdminMenu() {
        adminMenu.put(1, "Add customer to the bank");
        adminMenu.put(2, "Change customer name");
        adminMenu.put(3, "Check account balance");
        adminMenu.put(4, "Modify account balance");
        adminMenu.put(5, "Summary of all accounts");
        adminMenu.put(6, "Quit");
        for(Map.Entry<Integer, String> maEntry : adminMenu.entrySet())
        {
            System.out.println( "(" + maEntry.getKey() + "): " + maEntry.getValue());
        }
    }

    void handleUserInput(int userInput){
        switch (userInput){
            case 1: addCustomer(); break;
            case 2: changeCustomerName(); break;
            case 3: checkAccountBalance(); break;
            case 4: modifyAccountBalance();break;
            case 5: showSummary();break;
            case 6: System.exit(0);
            default:
                System.out.println(" Please Enter a valid option ");
        }
    }

    public void showSummary() {
        System.out.println( Decorator.msgHeaderDecorator + "Account Summary" + Decorator.msgHeaderDecorator);
        if (customerList.isEmpty()) {
            System.out.println("No accounts to show");
        }else {
            for (Customer customer : customerList) {
                System.out.println(customer.toString());
            }
        }
    }

    public void modifyAccountBalance() {
        System.out.println(Decorator.msgHeaderDecorator + "Deposit or Withdraw " + Decorator.msgHeaderDecorator);
        System.out.print("Enter account number: ");
        int accNumber = inputScanner.nextInt();
        Customer customer = findCustomer(accNumber);
        if (customer == null)
            System.out.println("Customer not found.");
        else {
            System.out.println("(1): Deposit");
            System.out.println("(2): Withdraw");
            int actionType = inputScanner.nextInt();
            System.out.print("Enter the amount: ");
            int amount = inputScanner.nextInt();
            if (actionType == 1) {
                customer.setBalance(customer.getBalance() + amount);
            }else if (actionType == 2) {
                if (amount <= customer.getBalance())
                    customer.setBalance(customer.getBalance() - amount);
                else
                    System.out.println("Insufficient funds!!!");
            }
        }
    }

    public void checkAccountBalance() {
        System.out.println(Decorator.msgHeaderDecorator + "Get Account Balance" + Decorator.msgHeaderDecorator);
        System.out.print("Enter account number: ");
        int accNumber = inputScanner.nextInt();
        Customer customer = findCustomer(accNumber);
        if (customer == null)
            System.out.println("Customer not found.");
        else
            System.out.println("Balance: " + customer.getBalance());
    }

    private static Customer findCustomer(int accNumber) {
        for (Customer customer: customerList) {
            if(customer.getAccNumber() == accNumber)
                return customer;
        }
        return null;
    }

    public void changeCustomerName() {
        System.out.println(Decorator.msgHeaderDecorator + " Change Customer Name" + Decorator.msgHeaderDecorator);
        System.out.print("Enter account number: ");
        int accNumber = inputScanner.nextInt();
        Customer customer = findCustomer(accNumber);
        if (customer == null)
            System.out.println("Customer not found");
        else {
            System.out.print("Please provide a new name: ");
            String newName = inputScanner.next();
            customer.setName(newName);
            System.out.println("Name changed successfully!!");
        }
    }

    public void addCustomer(){
        String name;
        int balance;
        int accNumber;
        System.out.println(Decorator.msgHeaderDecorator + "Please enter user details" + Decorator.msgHeaderDecorator);
        System.out.print("Enter Name: ");
        name = inputScanner.next();
        System.out.print("Enter balance: ");
        balance = inputScanner.nextInt();
        accNumber = accNumberGenerator.nextInt(1000);
        customerList.add(new Customer(name,balance, accNumber));
        System.out.println("User added!!!" + "\n" + "Account No.: " + accNumber + ", Name: " + name);
    }
}
