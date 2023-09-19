package com.pro.infomate.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatRoomDTO {

    private int chatRoomCode;

    private String chatRoomName;

    private LocalDateTime chatRoomCreateDate;

    private List<ChatRoomMemberDTO> chatRoomMemberList;

}
