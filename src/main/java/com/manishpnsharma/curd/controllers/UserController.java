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
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NO User PRESENT WITH ID : " + id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Create the resource
        User createdUser = userService.createUser(user);
        // Return the created resource with a 201 (created) status code
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleNotFoundException(ResponseStatusException ex) {
        return new ResponseEntity<>(ex.getReason(), ex.getStatusCode());
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