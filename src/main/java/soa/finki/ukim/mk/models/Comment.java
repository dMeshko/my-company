package soa.finki.ukim.mk.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DarkoM on 07.5.2017.
 */

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    private String content;
    private Date createdOn;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private Post post;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
