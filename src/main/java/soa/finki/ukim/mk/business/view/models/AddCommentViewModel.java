package soa.finki.ukim.mk.business.view.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by DarkoM on 27.5.2017.
 */
public class AddCommentViewModel {
    @NotEmpty @Size(min = 3)
    private String content;
    @NotNull @Min(1)
    private Long authorId;
    @NotNull @Min(1)
    private Long postId;

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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
