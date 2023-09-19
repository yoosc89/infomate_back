package com.pro.infomate.chat.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChatRoomMemberPK implements Serializable {

    @Id
    @Column(name = "CHATROOM_CODE")
    private int chatRoomCode;

    @Id
    @Column(name = "MEMBER_CODE")
    private int memberCode;
}
