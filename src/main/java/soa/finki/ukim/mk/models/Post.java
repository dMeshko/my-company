package soa.finki.ukim.mk.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by DarkoM on 07.5.2017.
 */

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {
    private String title;
    private String content;
    private Date createdOn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private List<Attachment> attachments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
