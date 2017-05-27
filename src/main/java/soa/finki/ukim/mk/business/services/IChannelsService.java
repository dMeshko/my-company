package soa.finki.ukim.mk.business.services;

import soa.finki.ukim.mk.business.view.models.*;

import java.util.List;

/**
 * Created by DarkoM on 12.5.2017.
 */
public interface IChannelsService {
    List<ChannelViewModel> getAll();
    ChannelViewModel getChannelById(Long channelId) throws Exception;
    Long create(CreateChannelViewModel channel) throws Exception;
    Long delete(Long channelId) throws Exception;
    List<UserViewModel> getChannelMembers(Long channelId) throws Exception;
    List<PostViewModel> getAllPostsForChannel(Long channelId) throws Exception;
    Long addPost(AddPostViewModel post) throws Exception;
    Long deletePost(Long postId) throws Exception;
    Long addComment(AddCommentViewModel comment) throws Exception;
    Long deleteComment(Long commentId) throws Exception;
}
