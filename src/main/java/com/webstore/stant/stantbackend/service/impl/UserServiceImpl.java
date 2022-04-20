package com.webstore.stant.stantbackend.service.impl;

import com.webstore.stant.stantbackend.dto.UserRegisterDto;
import com.webstore.stant.stantbackend.entity.Role;
import com.webstore.stant.stantbackend.entity.User;
import com.webstore.stant.stantbackend.repository.RoleRepository;
import com.webstore.stant.stantbackend.repository.UserRepository;
import com.webstore.stant.stantbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void save(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setActive(userRegisterDto.isActive());

        List<Role> roles= new ArrayList<>();
        Role role = new Role();
        role.setRole(userRegisterDto.getRole());
        roleRepository.save(role);
        roles.add(role);
        user.setRoles(roles);
        user.setEmail(userRegisterDto.getEmail());
        user.setName(userRegisterDto.getName());
        user.setPassword(userRegisterDto.getPassword());
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(userRepository.getById(id));

    }
    @Override
    public User findByEmailAddress(String email) {
        return userRepository.findByEmail(email);
    }
}
