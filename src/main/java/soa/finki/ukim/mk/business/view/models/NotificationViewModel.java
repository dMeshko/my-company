package soa.finki.ukim.mk.business.view.models;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class NotificationViewModel {
    private Long id;
    private UserViewModel userFrom;
    private String content;
    private String notificationType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserViewModel getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(UserViewModel userFrom) {
        this.userFrom = userFrom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
