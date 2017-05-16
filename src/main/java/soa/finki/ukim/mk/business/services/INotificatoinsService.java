package soa.finki.ukim.mk.business.services;

import soa.finki.ukim.mk.business.view.models.NotificationViewModel;

import java.util.List;

/**
 * Created by DarkoM on 12.5.2017.
 */
public interface INotificatoinsService {
    NotificationViewModel getById(Long notificatoinId) throws Exception;
    List<NotificationViewModel> getNotificatoinsForUser(Long userId) throws Exception;
}
