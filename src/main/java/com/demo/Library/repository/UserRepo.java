package com.demo.Library.repository;

import com.demo.Library.LibraryApplication;
import com.demo.Library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
