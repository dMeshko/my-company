package soa.finki.ukim.mk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.finki.ukim.mk.business.services.INotificatoinsService;
import soa.finki.ukim.mk.business.view.models.NotificationViewModel;

import java.util.List;

/**
 * Created by DarkoM on 14.5.2017.
 */

@RestController
@RequestMapping(value = "/api/notification", produces = MediaType.APPLICATION_JSON_VALUE)
public class NotificationsController {
    @Autowired
    private INotificatoinsService notificatoinsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public NotificationViewModel getNotification(@PathVariable Long id) throws Exception {
        return notificatoinsService.getById(id);
    }

    @RequestMapping(value = "/user/{id}")
    public List<NotificationViewModel> getNotificationsForuser(@PathVariable Long id) throws Exception {
        return notificatoinsService.getNotificatoinsForUser(id);
    }
}
