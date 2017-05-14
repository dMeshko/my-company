package soa.finki.ukim.mk.business.services.implementation;

import org.h2.command.dml.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.finki.ukim.mk.business.view.models.RegisterUserViewModel;
import soa.finki.ukim.mk.business.view.models.UpdateUserViewModel;
import soa.finki.ukim.mk.models.User;
import soa.finki.ukim.mk.repositories.IUserRepository;
import soa.finki.ukim.mk.business.services.IUsersService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarkoM on 07.5.2017.
 */

@Service
public class UsersService implements IUsersService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);

        return result;
    }

    @Override
    public Long register(RegisterUserViewModel user) {
        User dboUser = new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPhoneNumber());
        return userRepository.save(dboUser).getId();
    }

    @Override
    public Long update(UpdateUserViewModel user) {
        User dboUser = userRepository.findOne(user.getId());
        dboUser.setFirstName(user.getFirstName());
        dboUser.setLastName(user.getLastName());
        dboUser.setEmail(user.getEmail());
        dboUser.setPassword(user.getPassword());
        dboUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(dboUser);

        return dboUser.getId();
    }

    @Override
    public Long delete(Long userId) throws Exception {
        if (userId < 1)
            throw new Exception("The id has to be greater than 0!");

        userRepository.delete(userId);

        return userId;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
