package com.pro.infomate.chat.entity;

import com.pro.infomate.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CHATROOM_MEMBER_LIST")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ChatRoomMemberPK.class)
public class ChatRoomMember {

    @Id
    @Column(name = "REF_CHATROOM_CODE")
    private int chatRoomCode;

    @Id
    @Column(name = "REF_MEMBER_CODE")
    private int memberCode;

    @ManyToOne
    private Member memberList;

    @ManyToOne
    private ChatRoom chatRoom;
}
