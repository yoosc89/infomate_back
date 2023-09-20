package com.pro.infomate.chat;


import com.pro.infomate.chat.entity.ChatRoom;
import com.pro.infomate.chat.entity.ChatRoomMember;
import com.pro.infomate.chat.repository.ChatRoomMemberRepository;
import com.pro.infomate.chat.repository.ChatRoomRepository;
import com.pro.infomate.exception.NotFindDataException;
import com.pro.infomate.member.entity.Member;
import com.pro.infomate.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
//@Transactional
//@RequiredArgsConstructor
@Slf4j
public class Test {


    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Autowired
    ChatRoomMemberRepository chatRoomMemberRepository;

    @Autowired
    MemberRepository memberRepository;

    @org.junit.jupiter.api.Test
    @DisplayName("채팅방 생성")
    void registChatRoom(){

        Member mem1 = memberRepository.findById(521).orElseThrow(()->new NotFindDataException("조회 불가"));
        Member mem2 = memberRepository.findById(522).orElseThrow(()->new NotFindDataException("조회 불가"));

        ChatRoom chatRoom = ChatRoom.builder()
                .chatRoomName("채팅방 테스트")
                .chatRoomCreateDate(LocalDateTime.now())
                .build();

        chatRoomRepository.save(chatRoom);

        List<ChatRoomMember> chatRoomMemberList = new ArrayList<>();
        chatRoomMemberList.add(new ChatRoomMember(mem1.getMemberCode(), chatRoom.getChatRoomCode()));
        chatRoomMemberList.add(new ChatRoomMember(mem2.getMemberCode(), chatRoom.getChatRoomCode()));
        chatRoomMemberRepository.saveAll(chatRoomMemberList);

//        log.info("[test](chatRoom) : {} ", chatRoom);
//        chatRoom.addChatRoomMember(mem1);
//        chatRoom.addChatRoomMember(mem2);

//        chatRoomRepository.save(chatRoom);

//        List<ChatRoomMember> chatRoomMember = new ArrayList<>();
//        chatRoomMember.add(new ChatRoomMember(chatRoom.getChatRoomCode(), 521));
//        chatRoomMember.add(new ChatRoomMember(chatRoom.getChatRoomCode(), 522));

//        chatRoomMemberRepository.saveAll(chatRoomMember);




    }
}
