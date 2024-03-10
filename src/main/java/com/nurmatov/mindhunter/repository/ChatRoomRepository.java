package com.nurmatov.mindhunter.repository;


import com.nurmatov.mindhunter.domain.entity.message.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    Optional<ChatRoom> findBySenderAndRecipient(String senderId, String recipientId);
}
