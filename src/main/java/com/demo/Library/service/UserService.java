package com.demo.Library.service;

import com.demo.Library.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User addUser(User user);
}
