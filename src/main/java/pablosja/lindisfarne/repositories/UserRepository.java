package pablosja.lindisfarne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pablosja.lindisfarne.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
