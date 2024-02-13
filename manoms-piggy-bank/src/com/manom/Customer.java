package com.manom;

public class Customer {
    private String name;
    private double balance;
    private int accNumber;

    public Customer(String name, int accNumber) {
        this.name = name;
        this.accNumber = accNumber;
    }

    public Customer(String name, int balance, int accNumber) {
        this.name = name;
        this.balance = balance;
        this.accNumber = accNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    @Override
    public String toString() {
        return "Account No.: " + this.accNumber + ", Name: " + this.name + ", Balance: $" + this.balance;
    }

    @Override
    public int hashCode() {
        return this.accNumber * 8;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if(!(obj instanceof Customer))
            return false;
        Customer tempCustom = (Customer) obj;

        if (this.accNumber == tempCustom.accNumber && this.name == tempCustom.name)
            return true;

        return false;
    }
}
