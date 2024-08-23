package com.demo.Library.service;

import com.demo.Library.model.Book;
import com.demo.Library.model.User;
import com.demo.Library.repository.BookRepo;
import com.demo.Library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpli implements BookService{

    @Autowired
    private BookRepo brepo;

    @Autowired
    private UserRepo urepo;

    @Override
    public List<Book> displayAll() {
        return brepo.findAll();
    }

    @Override
    public Book findById(long id) {
        return brepo.findById(id).orElseThrow(()->new RuntimeException("Book with id "+id+" not found"));
    }

    @Override
    public Book addBook(Book book) {
        return brepo.save(book);
    }

    @Override
    public Book deleteById(long id) {
        Book b = brepo.findById(id).orElseThrow(()->new RuntimeException("Book with id "+id+" not found"));
        brepo.deleteById(id);
        return b;
    }

    @Override
    public Book borrowBook(long bID, long uID) {
        Book b = brepo.findById(bID).orElseThrow(()->new RuntimeException("Book with id "+ bID +" not found"));
        User u = urepo.findById(uID).orElseThrow(()->new RuntimeException("Book with id "+ uID +" not found"));

        if( b != null && u!=null && !b.isBorrowed()){
            b.setBorrowed(true);
            b.setBorrowedBy(u);
            return addBook(b);
        }

        return null;

    }

    @Override
    public Book returnBook(long bId) {
        Book book = findById(bId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return addBook(book);
        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null;
    }
}
