package soa.finki.ukim.mk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import soa.finki.ukim.mk.business.services.IChannelsService;
import soa.finki.ukim.mk.business.view.models.*;
import soa.finki.ukim.mk.controllers.helpers.ErrorMessageHandler;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by DarkoM on 14.5.2017.
 */

@RestController
@RequestMapping(value = "/api/channel", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChannelsController {
    @Autowired
    private IChannelsService channelsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ChannelViewModel> getAllChannels(){
        return channelsService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ChannelViewModel getChannel(@PathVariable Long id) throws Exception {
        return channelsService.getChannelById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object create(@Valid CreateChannelViewModel channel, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            return ErrorMessageHandler.ParseErrors(bindingResult.getFieldErrors());

        return channelsService.create(channel);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Long delete(@PathParam("id") Long id) throws Exception {
        return channelsService.delete(id);
    }

    @RequestMapping(value = "/{id}/members", method = RequestMethod.GET)
    public List<UserViewModel> getChannelMembers(@PathVariable Long id) throws Exception {
        return channelsService.getChannelMembers(id);
    }

    @RequestMapping(value = "/{id}/post", method = RequestMethod.GET)
    public List<PostViewModel> getAllPostsForChannel(@PathVariable Long id) throws Exception {
        return channelsService.getAllPostsForChannel(id);
    }

    @RequestMapping(value = "/{id}/post", method = RequestMethod.POST)
    public Object addPost(@Valid AddPostViewModel post, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            return ErrorMessageHandler.ParseErrors(bindingResult.getFieldErrors());

        return channelsService.addPost(post);
    }

    @RequestMapping(value = "/{id}/post/{postId}", method = RequestMethod.DELETE)
    public Long deletePost(@PathParam("postId") Long postId) throws Exception {
        return channelsService.deletePost(postId);
    }

    @RequestMapping(value = "/{id}/post/{postId}", method = RequestMethod.POST)
    public Object addComment(@Valid AddCommentViewModel comment, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            return ErrorMessageHandler.ParseErrors(bindingResult.getFieldErrors());

        return channelsService.addComment(comment);
    }

    @RequestMapping(value = "/{id}/post/{postId}/{commentId}", method = RequestMethod.DELETE)
    public Long deleteComment(@PathParam("commentId") Long commentId) throws Exception {
        return channelsService.deleteComment(commentId);
    }
}
