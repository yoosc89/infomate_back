package com.pro.infomate.chat.dto;

import com.pro.infomate.member.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatRoomMemberDTO {

    private int chatRoomCode;

    private int memberCode;

    private MemberDTO memberList;

}
