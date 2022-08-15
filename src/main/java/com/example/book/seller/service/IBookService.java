package com.example.book.seller.service;

import com.example.book.seller.model.Book;

import java.util.List;

public interface IBookService
{
    Book saveBook(Book book);

    void delete(Long id);

    List<Book> findAll();
}
