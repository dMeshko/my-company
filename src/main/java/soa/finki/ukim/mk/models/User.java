package soa.finki.ukim.mk.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarkoM on 07.5.2017.
 */

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;

    protected User(){}

    public User(String firstName, String lastName, String email, String password, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;

        administratingChannels = new ArrayList<>();
        helpfulPosts = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "admin")
    private List<Channel> administratingChannels;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "helpful_posts", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"))
    private List<Post> helpfulPosts;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userTo")
    private List<Notification> notifications;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Channel> getAdministratingChannels() {
        return administratingChannels;
    }

    public void setAdministratingChannels(List<Channel> administratingChannels) {
        this.administratingChannels = administratingChannels;
    }

    public List<Post> getHelpfulPosts() {
        return helpfulPosts;
    }

    public void setHelpfulPosts(List<Post> helpfulPosts) {
        this.helpfulPosts = helpfulPosts;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
