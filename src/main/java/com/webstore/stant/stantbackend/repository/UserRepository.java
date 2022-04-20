package com.webstore.stant.stantbackend.repository;

import com.webstore.stant.stantbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
