package soa.finki.ukim.mk.business.view.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarkoM on 27.5.2017.
 */
public class AddPostViewModel {
    @NotEmpty @Size(min = 3)
    private String title;

    @NotEmpty @Size(min = 3)
    private String content;

    @NotNull @Min(1)
    private Long authorId;

    @NotNull @Min(1)
    private Long channelId;

    private List<MultipartFile> attachments;

    public AddPostViewModel(){
        attachments = new ArrayList<>();
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public List<MultipartFile> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<MultipartFile> attachments) {
        this.attachments = attachments;
    }
}
