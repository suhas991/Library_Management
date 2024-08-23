package com.demo.Library.service;

import com.demo.Library.model.User;
import com.demo.Library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpli implements UserService{

    @Autowired
    private UserRepo userrepo;

    @Override
    public List<User> findAll() {
        return userrepo.findAll();
    }

    @Override
    public User addUser(User user) {
        return userrepo.save(user);
    }

}
