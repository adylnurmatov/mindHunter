package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.domain.entity.message.ChatRoom;
import com.nurmatov.mindhunter.repository.ChatRoomRepository;
import com.nurmatov.mindhunter.service.message.ChatRoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoom(
            String sender,
            String recipient,
            boolean createNewRoomIfNotExists
    ) {
        return chatRoomRepository
                .findBySenderAndRecipient(sender, recipient)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if(createNewRoomIfNotExists) {
                        var chatId = createChatId(sender, recipient);
                        return Optional.of(chatId);
                    }
                    return  Optional.empty();
                });
    }



    private String createChatId(String sender, String recipient) {
        var chatId = String.format("%s_%s", sender, recipient);

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(chatId)
                .sender(sender)
                .recipient(recipient)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(chatId)
                .sender(recipient)
                .recipient(sender)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}
