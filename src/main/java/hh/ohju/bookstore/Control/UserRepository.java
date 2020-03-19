package hh.ohju.bookstore.Control;

import hh.ohju.bookstore.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
