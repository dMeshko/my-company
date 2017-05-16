package soa.finki.ukim.mk.business.view.mappers;

import soa.finki.ukim.mk.business.view.models.PostViewModel;
import soa.finki.ukim.mk.models.Attachment;
import soa.finki.ukim.mk.models.Comment;
import soa.finki.ukim.mk.models.Post;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class PostMapper {
    public PostViewModel mapToViewModel(Post post){
        PostViewModel postViewModel = new PostViewModel();

        postViewModel.setId(post.getId());
        postViewModel.setTitle(post.getTitle());
        postViewModel.setContent(post.getContent());
        postViewModel.setAuthor(UserMapper.mapToViewModel(post.getAuthor()));
        postViewModel.setChannel(ChannelMapper.mapToViewModel(post.getChannel()));
        postViewModel.setCreatedOn(post.getCreatedOn());

        for (Attachment attachment : post.getAttachments())
            postViewModel.getAttachments().add(AttachmentMapper.mapToLookupViewModel(attachment));

        for (Comment comment : post.getComments())
            postViewModel.getComments().add(CommentMapper.mapToViewModel(comment));

        return postViewModel;
    }
}
