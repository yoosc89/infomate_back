package com.pro.infomate.chat.repository;

import com.pro.infomate.chat.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {

    @Query(value = "select c " +
            "from ChatRoom c, ChatRoomMember cm " +
            "where cm.memberCode = :memberCode"
    )
    List<ChatRoom> findAllByChatroom(int memberCode);
}
