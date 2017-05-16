package soa.finki.ukim.mk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soa.finki.ukim.mk.business.services.IChannelsService;

/**
 * Created by DarkoM on 14.5.2017.
 */

@RestController
@RequestMapping(value = "/api/channel", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChannelsController {
    @Autowired
    private IChannelsService channelsService;


}
