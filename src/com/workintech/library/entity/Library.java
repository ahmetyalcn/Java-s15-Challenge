package com.workintech.library.entity;

import com.workintech.library.enums.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements LibraryManagementSystem {
    private Map<Integer, Book> books;
    private Map<Integer, User> users;
    private Map<String,String> librarians;


    public Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
        this.librarians = new HashMap<>();
    }

    public Map<Integer, User> getUsers() {
        return users;
    }
    public Map<Integer, Book> getBooks() {
        return books;
    }
    public Map<String, String> getLibrarians() {
        return librarians;
    }

    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }
    @Override
    public void removeBook(int id) {
        books.remove(id);
    }
    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }
    @Override
    public void addLibrarian(Librarian librarian) {
        if (librarian != null){
            librarians.put(librarian.getName(), librarian.getPassword());
        }else {
            System.out.println("There is no librarian");
        }
    }
    @Override
    public void updateBook(int id, String title, String author, Category category, double price) {
        Book book = books.get(id);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setCategory(category);
            book.setPrice(price);
        }
    }
    @Override
    public List<Book> listBooksByCategory(Category category) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getCategory().equals(category)) {
                result.add(book);
            }
        }
        return result;
    }
    @Override
    public List<Book> listBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().toLowerCase().equals(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
    @Override
    public boolean borrowBook(int userId, int bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);

        if (user == null || book == null || user.getBorrowedBooks().size() >= 5 || book.isBorrowed()) {
            System.out.println("You can't borrow the book");
            return false;
        }
        user.setBalance(user.getBalance()-book.getPrice());
        user.getBorrowedBooks().add(book);
        book.setBorrowed(true);
        return true;
    }
    @Override
    public boolean returnBook(int userId, int bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);

        if (user == null || book == null || !book.isBorrowed() || !user.getBorrowedBooks().contains(book)) {
            return false;
        }
        user.setBalance(user.getBalance()+book.getPrice());
        user.getBorrowedBooks().remove(book);
        book.setBorrowed(false);
        return true;
    }
}
