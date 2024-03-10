package com.nurmatov.mindhunter.service.message;

import java.util.Optional;

public interface ChatRoomService {
    Optional<String> getChatRoom(String sender, String recipient, boolean b);
}
