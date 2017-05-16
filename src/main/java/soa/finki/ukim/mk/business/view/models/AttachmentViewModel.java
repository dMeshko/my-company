package soa.finki.ukim.mk.business.view.models;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class AttachmentViewModel {
    private String name;
    private String contentType;
    private byte[] file;

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
}
