package tech.backend.livechat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import tech.backend.livechat.domain.ChatInput;
import tech.backend.livechat.domain.ChatOutPut;

@Controller
public class LiveChatController {

    @MessageMapping("/new-massage")
    @SendTo("/topics/livechat")
    public ChatOutPut newMessage(ChatInput input) {
        return new ChatOutPut(HtmlUtils.htmlEscape(input.user() + ": " + input.message()));
    }
}
