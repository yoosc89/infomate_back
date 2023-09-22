package com.pro.infomate.chat.dto;

import com.pro.infomate.chat.entity.ChatRoom;
import com.pro.infomate.member.dto.MemberDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatRoomMemberDTO {

    private int chatRoomCode;

    private int memberCode;

    private MemberDTO member;

    private ChatRoomDTO chatRoom;

    @Override
    public String toString() {
        return "ChatRoomMemberDTO{" +
                "chatRoomCode=" + chatRoomCode +
                ", memberCode=" + memberCode +
                '}';
    }
}
