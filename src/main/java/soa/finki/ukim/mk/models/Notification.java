package soa.finki.ukim.mk.models;

import javax.persistence.*;

/**
 * Created by DarkoM on 07.5.2017.
 */

@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id")
    private User userFrom;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id")
    private User userTo;

    private String content;

    @Enumerated(EnumType.ORDINAL)
    private NotificationType type;
}
