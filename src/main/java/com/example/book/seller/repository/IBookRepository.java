package com.example.book.seller.repository;

import com.example.book.seller.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long>
{

}
