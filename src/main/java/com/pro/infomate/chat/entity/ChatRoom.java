package com.pro.infomate.chat.entity;

import com.pro.infomate.member.entity.Member;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "TBL_CHATROOM")
@SequenceGenerator(
        name = "SEQ_TBL_CHATROOM_GEN",
        sequenceName = "SEQ_TBL_CHATROOM_CODE",
        initialValue = 1, allocationSize = 1
)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ChatRoom {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_TBL_CHATROOM_GEN"
    )
    @Column(name = "CHATROOM_CODE")
    private int chatRoomCode;

    @Column(name = "CHATROOM_NAME")
    private String chatRoomName;

    @Column(name = "CHATROOM_CREATE_DATE")
    private LocalDateTime chatRoomCreateDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = ChatRoomMember.class)
    @JoinColumn(name = "CHATROOM_CODE")
    private List<ChatRoomMember> chatRoomMemberList = new ArrayList<>();

    public void addChatRoomMember(Member member) {
        this.chatRoomMemberList = new ArrayList<>();
        this.chatRoomMemberList.add(new ChatRoomMember(member, this));
    }
}
