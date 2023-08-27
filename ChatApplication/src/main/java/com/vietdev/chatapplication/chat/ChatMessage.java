package com.vietdev.chatapplication.chat;

import lombok.*;

/**
 * @author VietDev
 * @date 27/08/2023
 * @role
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    private MessageType type;
    private String content;
    private String sender;

}