package com.pro.infomate.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @OneToMany
    @JoinColumn(name = "CHATROOM_CODE")
    private List<ChatRoomMember> chatRoomMemberList;
}
