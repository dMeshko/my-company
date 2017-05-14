package soa.finki.ukim.mk.repositories;

import org.springframework.data.repository.CrudRepository;
import soa.finki.ukim.mk.models.Notification;

/**
 * Created by DarkoM on 12.5.2017.
 */
public interface INotificationRepository extends CrudRepository<Notification, Long> {
}
