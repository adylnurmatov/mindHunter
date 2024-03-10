package com.nurmatov.mindhunter.service.message;


import com.nurmatov.mindhunter.domain.entity.message.ChatMessage;
import com.nurmatov.mindhunter.web.dto.message.MessageDto;

import java.util.List;

public interface ChatMessageService {
    ChatMessage save(MessageDto chatMessage);

    List<ChatMessage> findChatMessages(String senderId, String recipientId);
}
