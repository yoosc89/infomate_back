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

    private int chatRoomCode;

    private int memberCode;
}
