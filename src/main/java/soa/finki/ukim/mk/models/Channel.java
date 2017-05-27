package soa.finki.ukim.mk.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarkoM on 07.5.2017.
 */

@Entity
@Table(name = "channels")
public class Channel extends BaseEntity {
    private String name;

    @ManyToOne()
    @JoinColumn(name = "admin_id")
    private User admin;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_channels", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<User> members;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "channel")
    private List<Post> posts;

    public Channel(){
        members = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
