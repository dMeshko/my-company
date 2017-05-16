package soa.finki.ukim.mk.business.view.mappers;

import soa.finki.ukim.mk.business.view.models.AttachmentViewModel;
import soa.finki.ukim.mk.business.view.models.LookupViewModel;
import soa.finki.ukim.mk.models.Attachment;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class AttachmentMapper {
    public static AttachmentViewModel mapToViewModel(Attachment attachment){
        AttachmentViewModel attachmentViewModel = new AttachmentViewModel();

        attachmentViewModel.setName(attachment.getName());
        attachmentViewModel.setContentType(attachment.getContentType());
        attachmentViewModel.setFile(attachment.getFile());

        return attachmentViewModel;
    }

    public static LookupViewModel mapToLookupViewModel(Attachment attachment){
        return new LookupViewModel(attachment.getId(), attachment.getName());
    }
}
