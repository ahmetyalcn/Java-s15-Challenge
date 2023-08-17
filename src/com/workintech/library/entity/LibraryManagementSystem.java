package com.workintech.library.entity;

import com.workintech.library.enums.Category;

import java.util.List;

public interface LibraryManagementSystem {
    void addUser(User user);
    void addLibrarian(Librarian librarian);
    void addBook(Book book);
    void updateBook(int id, String title, String author, Category category, double price);
    void removeBook(int id);
    List<Book> listBooksByCategory(Category category);
    List<Book> listBooksByAuthor(String author);
    boolean borrowBook(int userId, int bookId);
    boolean returnBook(int userId, int bookId);
}
