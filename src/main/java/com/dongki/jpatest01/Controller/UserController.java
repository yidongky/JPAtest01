package com.dongki.jpatest01.Controller;

import com.dongki.jpatest01.Entity.Users;
import com.dongki.jpatest01.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/users")
    @ResponseBody
    public ResponseEntity<?> getUsers(@RequestParam(required = false, defaultValue = "dongki") String name) {
        List<Users> users = usersService.getUsersService(name);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping(value = "/user")
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody Users user) {
        usersService.createUserService(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
