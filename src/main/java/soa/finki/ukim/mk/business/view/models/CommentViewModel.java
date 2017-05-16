package soa.finki.ukim.mk.business.view.models;

import java.util.Date;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class CommentViewModel {
    private Long id;
    private String content;
    private Date createdOn;
    private UserViewModel author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserViewModel getAuthor() {
        return author;
    }

    public void setAuthor(UserViewModel author) {
        this.author = author;
    }
}
