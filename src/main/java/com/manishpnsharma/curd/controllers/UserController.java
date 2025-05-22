package com.manishpnsharma.curd.controllers;

import com.manishpnsharma.curd.exceptions.NoSuchUserExistsException;
import com.manishpnsharma.curd.exceptions.ResourceNotFoundException;
import com.manishpnsharma.curd.module.User;
import com.manishpnsharma.curd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userService.getUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NO User PRESENT WITH ID : " + id));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUserByIdExp(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseThrow(() -> new NoSuchUserExistsException(id, "NO USER PRESENT WITH ID : ", "HttpStatus"));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserExp(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("Record deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> userUpdate(@PathVariable Long id, @RequestBody User user) {
        User userUpdate = userService.getUserById(id)
                .orElseThrow(() -> new NoSuchUserExistsException(id, "NO USER PRESENT WITH ID : ", "HttpStatus"));
        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setId(user.getId());
        userService.createUser(userUpdate);
        return ResponseEntity.ok(userUpdate);

    }
   /*@ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleNotFoundException(ResponseStatusException ex) {
        return new ResponseEntity<>(ex.getReason(), ex.getStatusCode());
    }*/
}