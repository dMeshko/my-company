package soa.finki.ukim.mk.business.view.mappers;

import soa.finki.ukim.mk.business.view.models.ChannelViewModel;
import soa.finki.ukim.mk.models.Channel;

/**
 * Created by DarkoM on 14.5.2017.
 */
public class ChannelMapper {
    public static ChannelViewModel mapToViewModel(Channel channel){
        ChannelViewModel channelViewModel = new ChannelViewModel();

        channelViewModel.setId(channel.getId());
        channelViewModel.setName(channel.getName());
        channelViewModel.setAdmin(UserMapper.mapToViewModel(channel.getAdmin()));

        return channelViewModel;
    }
}
