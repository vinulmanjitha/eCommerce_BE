package eCommerce.eCommerce.repositories;

import eCommerce.eCommerce.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByEmail(String email);

}
