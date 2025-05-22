package com.manishpnsharma.curd.repositories;
import com.manishpnsharma.curd.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findById(Long id);
    public void deleteById(Long id);
    public List<User> findAll();

   // public  Optional<User> save(User user);

}
