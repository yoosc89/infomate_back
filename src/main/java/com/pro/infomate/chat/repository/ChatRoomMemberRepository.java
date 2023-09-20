package com.pro.infomate.chat.repository;

import com.pro.infomate.chat.entity.ChatRoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomMemberRepository extends JpaRepository<ChatRoomMember, Integer> {
}
