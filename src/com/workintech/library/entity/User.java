package com.workintech.library.entity;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private double balance;
    private List<Book> borrowedBooks;

    public User(int id, String name, double balance) {
        super(id, name);
        this.balance = balance;
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", balance=" + balance +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }


}
