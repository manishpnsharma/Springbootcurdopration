package com.manishpnsharma.curd.services;

import com.manishpnsharma.curd.exceptions.NoSuchUserExistsException;
import com.manishpnsharma.curd.module.User;
import com.manishpnsharma.curd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

   public Optional<User> getUserById(Long id) throws NoSuchUserExistsException {
        // return userRepository.findById(id);
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("NO User PRESENT WITH ID = " + id)));
    }

   /* public User getUserById(Long id) throws NoSuchUserExistsException {
         return userRepository.findById(id);
        }*/

    public void userUpdate(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
