package soa.finki.ukim.mk.business.view.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class PostViewModel {
    private Long id;
    private String title;
    private String content;
    private Date createdOn;
    private UserViewModel author;
    private ChannelViewModel channel;
    private List<LookupViewModel> attachments;
    private List<CommentViewModel> comments;

    public PostViewModel(){
        attachments = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public UserViewModel getAuthor() {
        return author;
    }

    public void setAuthor(UserViewModel author) {
        this.author = author;
    }

    public ChannelViewModel getChannel() {
        return channel;
    }

    public void setChannel(ChannelViewModel channel) {
        this.channel = channel;
    }

    public List<LookupViewModel> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<LookupViewModel> attachments) {
        this.attachments = attachments;
    }

    public List<CommentViewModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentViewModel> comments) {
        this.comments = comments;
    }
}
