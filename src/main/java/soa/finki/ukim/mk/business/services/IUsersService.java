package soa.finki.ukim.mk.business.services;

import soa.finki.ukim.mk.business.view.models.RegisterUserViewModel;
import soa.finki.ukim.mk.business.view.models.UpdateUserViewModel;
import soa.finki.ukim.mk.models.User;

import java.util.List;

/**
 * Created by DarkoM on 07.5.2017.
 */

public interface IUsersService {
    List<User> getAll();
    Long register(RegisterUserViewModel user);
    Long update(UpdateUserViewModel user);
    Long delete(Long userId) throws Exception;
    User findByEmail(String email);
}
