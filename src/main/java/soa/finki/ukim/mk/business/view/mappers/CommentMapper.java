package soa.finki.ukim.mk.business.view.mappers;

import soa.finki.ukim.mk.business.view.models.CommentViewModel;
import soa.finki.ukim.mk.models.Comment;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class CommentMapper {
    public static CommentViewModel mapToViewModel(Comment comment){
        CommentViewModel commentViewModel = new CommentViewModel();

        commentViewModel.setId(comment.getId());
        commentViewModel.setContent(comment.getContent());
        commentViewModel.setCreatedOn(comment.getCreatedOn());
        commentViewModel.setAuthor(UserMapper.mapToViewModel(comment.getAuthor()));

        return commentViewModel;
    }
}
