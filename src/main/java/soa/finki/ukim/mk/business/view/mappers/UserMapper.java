package soa.finki.ukim.mk.business.view.mappers;

import soa.finki.ukim.mk.business.view.models.UserViewModel;
import soa.finki.ukim.mk.models.Channel;
import soa.finki.ukim.mk.models.User;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class UserMapper {
    public static UserViewModel mapToViewModel(User user){
        UserViewModel userViewModel = new UserViewModel();

        userViewModel.setId(user.getId());
        userViewModel.setFirstName(user.getFirstName());
        userViewModel.setLastName(user.getLastName());
        userViewModel.setEmail(user.getEmail());
        userViewModel.setPhoneNumber(user.getPhoneNumber());

        return userViewModel;
    }
}
