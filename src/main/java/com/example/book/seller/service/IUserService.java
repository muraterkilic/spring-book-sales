package com.example.book.seller.service;

import com.example.book.seller.model.User;

import java.util.Optional;

public interface IUserService
{
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}
