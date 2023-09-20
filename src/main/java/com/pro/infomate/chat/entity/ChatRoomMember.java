package com.pro.infomate.chat.entity;

import com.pro.infomate.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CHATROOM_MEMBER_LIST")
@Getter
@NoArgsConstructor
@IdClass(ChatRoomMemberPK.class)
@ToString
public class ChatRoomMember {

    @Id
    @Column(name = "REF_CHATROOM_CODE")
    private int chatRoomCode;

    @Id
    @Column(name = "REF_MEMBER_CODE")
    private int memberCode;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    @JoinColumn(name = "REF_MEMBER_CODE", insertable = false, updatable = false)
    private Member member;

    @ManyToOne(targetEntity = ChatRoom.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "REF_CHATROOM_CODE", insertable = false, updatable = false)
    private ChatRoom chatRoom;

    public ChatRoomMember(int memberCode, int chatRoomCode) {
        this.chatRoomCode = chatRoomCode;
        this.memberCode = memberCode;
    }

    public ChatRoomMember(Member member, ChatRoom chatRoom) {
        this.member = member;
        this.chatRoom = chatRoom;
    }
}
