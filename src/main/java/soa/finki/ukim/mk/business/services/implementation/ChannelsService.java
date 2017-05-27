package soa.finki.ukim.mk.business.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import soa.finki.ukim.mk.business.services.IChannelsService;
import soa.finki.ukim.mk.business.view.mappers.ChannelMapper;
import soa.finki.ukim.mk.business.view.mappers.PostMapper;
import soa.finki.ukim.mk.business.view.mappers.UserMapper;
import soa.finki.ukim.mk.business.view.models.*;
import soa.finki.ukim.mk.models.*;
import soa.finki.ukim.mk.repositories.IChannelRepository;
import soa.finki.ukim.mk.repositories.ICommentRepository;
import soa.finki.ukim.mk.repositories.IPostRepository;
import soa.finki.ukim.mk.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DarkoM on 12.5.2017.
 */

@Service
public class ChannelsService implements IChannelsService {
    @Autowired
    private IChannelRepository channelRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<ChannelViewModel> getAll() {
        List<ChannelViewModel> channels = new ArrayList<>();
        List<Channel> dboChannels = (List<Channel>) channelRepository.findAll();

        channels.addAll(dboChannels.stream().map(ChannelMapper::mapToViewModel).collect(Collectors.toList()));

        return channels;
    }

    @Override
    public ChannelViewModel getChannelById(Long channelId) throws Exception {
        Channel dboChannel = channelRepository.findOne(channelId);
        if (dboChannel == null)
            throw new Exception("There is no such channel!");

        return ChannelMapper.mapToViewModel(dboChannel);
    }

    @Override
    public Long create(CreateChannelViewModel channel) throws Exception {
        User admin = userRepository.findOne(channel.getAdminId());
        if (admin == null)
            throw new Exception("The channel must have creator!");

        Channel dboChannel = new Channel();
        dboChannel.setName(channel.getName());
        dboChannel.setAdmin(admin);

        dboChannel.getMembers().add(admin);
        for (Long memberId : channel.getMemberIds()){
            User member = userRepository.findOne(memberId);
            if (member == null)
                throw new Exception("There is no such member!");

            dboChannel.getMembers().add(member);
        }

        channelRepository.save(dboChannel);

        return dboChannel.getId();
    }

    @Override
    public Long delete(Long channelId) throws Exception {
        if (channelId < 1)
            throw new Exception("The id has to be greater than 0!");

        channelRepository.delete(channelId);

        return channelId;
    }

    @Override
    public List<UserViewModel> getChannelMembers(Long channelId) throws Exception {
        Channel channel = channelRepository.findOne(channelId);
        if (channel == null)
            throw new Exception("Channel not found!");

        List<UserViewModel> channelMembers = new ArrayList<>();
        List<User> members = channel.getMembers();
        channelMembers.addAll(members.stream().map(UserMapper::mapToViewModel).collect(Collectors.toList()));

        return channelMembers;
    }

    @Override
    public List<PostViewModel> getAllPostsForChannel(Long channelId) throws Exception {
        Channel channel = channelRepository.findOne(channelId);
        if (channel == null)
            throw new Exception("Channel not found!");

        List<PostViewModel> resultingPosts = new ArrayList<>();
        List<Post> posts = channel.getPosts();
        resultingPosts.addAll(posts.stream().map(PostMapper::mapToViewModel).collect(Collectors.toList()));

        return resultingPosts;
    }

    @Override
    public Long addPost(AddPostViewModel post) throws Exception {
        Channel channel = channelRepository.findOne(post.getChannelId());
        if (channel == null)
            throw new Exception("There is no such channel!");

        User author = userRepository.findOne(post.getAuthorId());
        if (author == null)
            throw new Exception("There is a problem fetching the author!");

        Post dboPost = new Post();
        dboPost.setChannel(channel);
        dboPost.setAuthor(author);
        dboPost.setCreatedOn(new Date());
        dboPost.setTitle(post.getTitle());
        dboPost.setContent(post.getContent());
        for (MultipartFile attachment : post.getAttachments()){
            Attachment dboAttachment = new Attachment();
            dboAttachment.setPost(dboPost);
            dboAttachment.setName(attachment.getName());
            dboAttachment.setContentType(attachment.getContentType());
            dboAttachment.setFile(attachment.getBytes());
        }
        postRepository.save(dboPost);

        return dboPost.getId();
    }

    @Override
    public Long deletePost(Long postId) throws Exception {
        if (postId < 1)
            throw new Exception("The id has to be greater than 0!");

        postRepository.delete(postId);

        return postId;
    }

    @Override
    public Long addComment(AddCommentViewModel comment) throws Exception {
        Post post = postRepository.findOne(comment.getPostId());
        if (post == null)
            throw new Exception("Post not found!");

        User author = userRepository.findOne(comment.getAuthorId());
        if (author == null)
            throw new Exception("There is a problem fetching the author!");

        Comment dboComment = new Comment();
        dboComment.setPost(post);
        dboComment.setAuthor(author);
        dboComment.setCreatedOn(new Date());
        dboComment.setContent(comment.getContent());

        commentRepository.save(dboComment);

        return dboComment.getId();
    }

    @Override
    public Long deleteComment(Long commentId) throws Exception {
        if (commentId < 1)
            throw new Exception("The id has to be greater than 0!");

        commentRepository.delete(commentId);

        return commentId;
    }
}
