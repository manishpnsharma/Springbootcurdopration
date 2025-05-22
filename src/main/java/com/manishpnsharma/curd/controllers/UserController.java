package com.manishpnsharma.curd.controllers;

import com.manishpnsharma.curd.exceptions.NoSuchUserExistsException;
import com.manishpnsharma.curd.module.User;
import com.manishpnsharma.curd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

   /* @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
       // String responseBody = "Request was successful!";
       // userService.getUserById(id).toString();
        return new ResponseEntity(userService.getUserById(id).toString(), HttpStatus.OK);
    }*/
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable User id) {
        userService.deleteUser(id);
    }

    @PutMapping
    public void userUpdate(@RequestBody User user) {
        userService.userUpdate(user);
    }

    @ExceptionHandler(NoSuchUserExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchUserExistsException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}