package com.webstore.stant.stantbackend.service;

import com.webstore.stant.stantbackend.dto.UserRegisterDto;
import com.webstore.stant.stantbackend.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User getById(long id);

    void save(UserRegisterDto userRegisterDto);
    void delete(long id);

    User findByEmailAddress(String email);
}
