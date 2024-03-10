package com.nurmatov.mindhunter.repository;

import com.nurmatov.mindhunter.domain.entity.message.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatId(String chatId);
}
