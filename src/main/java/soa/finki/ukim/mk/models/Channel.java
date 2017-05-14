package soa.finki.ukim.mk.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DarkoM on 07.5.2017.
 */

@Entity
@Table(name = "channels")
public class Channel extends BaseEntity {
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private User admin;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_channels", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<User> members;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "posts_channels", joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> posts;

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
