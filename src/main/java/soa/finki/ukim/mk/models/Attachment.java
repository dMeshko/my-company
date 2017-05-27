package soa.finki.ukim.mk.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by DarkoM on 07.5.2017.
 */

@Entity
@Table(name = "attachments")
public class Attachment extends BaseEntity {
    private String name;
    private String contentType;
    private byte[] file;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private Post post;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
