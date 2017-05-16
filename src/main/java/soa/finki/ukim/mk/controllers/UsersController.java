package soa.finki.ukim.mk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import soa.finki.ukim.mk.business.view.models.RegisterUserViewModel;
import soa.finki.ukim.mk.business.view.models.UpdateUserViewModel;
import soa.finki.ukim.mk.business.view.models.UserViewModel;
import soa.finki.ukim.mk.controllers.helpers.ErrorMessageHandler;
import soa.finki.ukim.mk.models.User;
import soa.finki.ukim.mk.business.services.IUsersService;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by DarkoM on 07.5.2017.
 */

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {
    @Autowired
    private IUsersService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserViewModel> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserViewModel getUser(@PathVariable Long id) throws Exception {
        return userService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object register(@Valid RegisterUserViewModel user, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return ErrorMessageHandler.ParseErrors(bindingResult.getFieldErrors());

        return userService.register(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Object update(@Valid UpdateUserViewModel user, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return ErrorMessageHandler.ParseErrors(bindingResult.getFieldErrors());

        return userService.update(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Long delete(@PathParam("id") Long id) throws Exception {
        return userService.delete(id);
    }

    @RequestMapping(value = "/email/{email:.+}", method = RequestMethod.GET)
    public UserViewModel getUserByEmail(@PathVariable String email) throws Exception {
        return userService.findByEmail(email);
    }
}
