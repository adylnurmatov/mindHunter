package com.nurmatov.mindhunter.web.controller;

import com.nurmatov.mindhunter.domain.entity.message.ChatMessage;
import com.nurmatov.mindhunter.domain.entity.message.ChatNotification;
import com.nurmatov.mindhunter.service.message.ChatMessageService;
import com.nurmatov.mindhunter.web.dto.message.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;
    @MessageMapping("/chat")
    public void processMessage(@Payload MessageDto chatMessage) {
        ChatMessage savedMsg = chatMessageService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipient(), "/queue/messages",
                new ChatNotification(
                        savedMsg.getId(),
                        savedMsg.getSender(),
                        savedMsg.getRecipient(),
                        savedMsg.getContent()
                )
        );
    }

    @GetMapping("/messages/{sender}/{recipient}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String sender,
                                                              @PathVariable String recipient) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(sender, recipient));
    }
}
