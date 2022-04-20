package com.webstore.stant.stantbackend.v1.controller;

import com.webstore.stant.stantbackend.dto.UserRegisterDto;
import com.webstore.stant.stantbackend.entity.User;
import com.webstore.stant.stantbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    final static String BASE_URL = "/api/v1/users";
    @GetMapping()
    public List<User> getUsers(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getById(@PathVariable long id) {
        return userService.getById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public void save(@RequestBody UserRegisterDto userRegisterDto) {
        userService.save(userRegisterDto);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }

}
