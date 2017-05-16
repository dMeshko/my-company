package soa.finki.ukim.mk.business.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.finki.ukim.mk.business.services.INotificatoinsService;
import soa.finki.ukim.mk.business.view.mappers.NotificationMapper;
import soa.finki.ukim.mk.business.view.models.NotificationViewModel;
import soa.finki.ukim.mk.models.Notification;
import soa.finki.ukim.mk.models.User;
import soa.finki.ukim.mk.repositories.INotificationRepository;
import soa.finki.ukim.mk.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DarkoM on 12.5.2017.
 */

@Service
public class NotificationsService implements INotificatoinsService {
    @Autowired
    private INotificationRepository notificationRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public NotificationViewModel getById(Long notificatoinId) throws Exception {
        Notification notification = notificationRepository.findOne(notificatoinId);
        if (notification == null)
            throw new Exception("There is no such notification!");

        return NotificationMapper.mapToViewModel(notification);
    }

    @Override
    public List<NotificationViewModel> getNotificatoinsForUser(Long userId) throws Exception {
        User user = userRepository.findOne(userId);
        if (user == null)
            throw new Exception("There is no such user!");

        List<Notification> userNotifications = user.getNotifications();
        List<NotificationViewModel> notifications = userNotifications.stream()
                .map(NotificationMapper::mapToViewModel).collect(Collectors.toList());

        return notifications;
    }
}
