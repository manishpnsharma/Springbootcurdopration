package com.manishpnsharma.curd.services;
import com.manishpnsharma.curd.exceptions.EmptyInputFieldException;
import com.manishpnsharma.curd.module.User;
import com.manishpnsharma.curd.repositories.UserRepository;
import jakarta.transaction.Transactional;
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
        if (user.getEmail().isBlank() || user.getEmail().isEmpty()) {
            throw new EmptyInputFieldException("232323", "sddadas");
        }
        return userRepository.save(user);
    }
    @Transactional
    public void deleteUserById(Long id) {

        if (id==0 || id.equals("") || id==null) {
            throw new EmptyInputFieldException("Invalid Input", "Input");
        }
        Optional.ofNullable(userRepository.findById(id).orElseThrow(
                 () -> new NoSuchElementException("NO User PRESENT WITH ID = " + id)));
        userRepository.deleteById(id);
    }
  /* public Optional<User> getUserById(Long id) throws NoSuchUserExistsException {
        return userRepository.findById(id);
       // return Optional.ofNullable(userRepository.findById(id).orElseThrow(
              // () -> new NoSuchElementException("NO User PRESENT WITH ID = " + id)));
    }*/
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
        }
   /* public User userUpdate(User user) {
        return userRepository.save(user);
    }*/
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
