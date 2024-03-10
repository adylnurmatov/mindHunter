package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.domain.entity.message.ChatMessage;
import com.nurmatov.mindhunter.domain.exception.ResourceNotFoundException;
import com.nurmatov.mindhunter.repository.ChatMessageRepository;
import com.nurmatov.mindhunter.service.message.ChatMessageService;
import com.nurmatov.mindhunter.service.message.ChatRoomService;
import com.nurmatov.mindhunter.web.dto.message.MessageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;
    public ChatMessage save(MessageDto messageDto) {
        String chatId = chatRoomService
                .getChatRoom(messageDto.getSender(), messageDto.getRecipient(), true)
                .orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
        ChatMessage chatMessage = ChatMessage.builder()
                .chatId(chatId)
                .content(messageDto.getContent())
                .sender(messageDto.getSender())
                .recipient(messageDto.getRecipient())
                .timestamp(LocalDateTime.now())
                .build();
        repository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String sender, String recipient) {
        var chatId = chatRoomService.getChatRoom(sender, recipient, false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}
