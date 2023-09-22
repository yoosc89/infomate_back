package com.pro.infomate.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter

@Setter
public class ChatRoomMemberPK implements Serializable {

    private int chatRoomCode;

    private int memberCode;
}
