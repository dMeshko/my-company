package soa.finki.ukim.mk.repositories;

import org.springframework.data.repository.CrudRepository;
import soa.finki.ukim.mk.models.User;

/**
 * Created by DarkoM on 07.5.2017.
 */


public interface IUserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
