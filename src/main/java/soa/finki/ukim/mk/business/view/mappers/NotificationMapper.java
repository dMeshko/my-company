package soa.finki.ukim.mk.business.view.mappers;

import soa.finki.ukim.mk.business.view.models.NotificationViewModel;
import soa.finki.ukim.mk.models.Notification;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class NotificationMapper {
    public static NotificationViewModel mapToViewModel(Notification notification){
        NotificationViewModel notificationViewModel = new NotificationViewModel();

        notificationViewModel.setId(notification.getId());
        notificationViewModel.setUserFrom(UserMapper.mapToViewModel(notification.getUserFrom()));
        notificationViewModel.setContent(notification.getContent());
        notificationViewModel.setNotificationType(notification.getType().toString());

        return notificationViewModel;
    }
}
