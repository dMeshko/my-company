package soa.finki.ukim.mk.business.view.models;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class ChannelViewModel {
    private Long id;
    private String name;
    private UserViewModel admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserViewModel getAdmin() {
        return admin;
    }

    public void setAdmin(UserViewModel admin) {
        this.admin = admin;
    }
}
