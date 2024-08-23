package com.demo.Library.service;

import com.demo.Library.model.Book;
import java.util.List;

public interface BookService {

    public List<Book> displayAll();
    public Book findById(long id);
    public Book addBook(Book book);
    public Book deleteById(long id);

    public Book borrowBook(long bID,long uID);
    public Book returnBook(long bId);

}
