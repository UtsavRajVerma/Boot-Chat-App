package com.utsavproject.chatapp_boot;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Model sendMessage(@Payload Model model) {
        return model;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Model addUser(@Payload Model model, SimpMessageHeaderAccessor headerAccessor) {

// Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", model.getSender());
        return model;
    }
}
