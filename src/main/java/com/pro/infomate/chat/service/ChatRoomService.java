package com.pro.infomate.chat.service;


import com.pro.infomate.chat.dto.ChatRoomDTO;
import com.pro.infomate.chat.entity.ChatRoom;
import com.pro.infomate.chat.entity.ChatRoomMember;
import com.pro.infomate.chat.repository.ChatRoomMemberRepository;
import com.pro.infomate.chat.repository.ChatRoomRepository;
import com.pro.infomate.exception.NotFindDataException;
import com.pro.infomate.member.entity.Member;
import com.pro.infomate.member.repository.MemberRepository;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    private final ChatRoomMemberRepository ChatRoomMemberRepository;

    private final MemberRepository memberRepository;

    private final ModelMapper modelMapper;


    private ChatRoomDTO findByChatRoom(int roomCode){
        ChatRoom chatRoom = chatRoomRepository.findById(roomCode)
                .orElseThrow(()-> new NotFindDataException("채팅방을 찾을 수 없습니다."));
        return modelMapper.map(chatRoom, ChatRoomDTO.class);
    }

    public ChatRoomDTO registChatRooms(List<Integer> memberList) {
        ChatRoom chatRoom = ChatRoom.builder()
                .chatRoomName("채팅방 테스트")
                .chatRoomCreateDate(LocalDateTime.now())
                .build();

        chatRoomRepository.save(chatRoom);

        ChatRoomMemberRepository.saveAll(memberList.stream()
                .map(member ->
                        new ChatRoomMember(member, chatRoom.getChatRoomCode())
                ).collect(Collectors.toList())
        );

        return modelMapper.map(chatRoom, ChatRoomDTO.class);
    }

    public ChatRoomDTO findByChatRoomCode(int roomCode) {

        return findByChatRoom(roomCode);

    }

    public void updateByChatroom(int roomCode, ChatRoomDTO chatRoomDTO) {

//        ChatRoom chatRoom = findByChatRoom(roomCode);


        // 수정 로직

    }

    public void addRoomMember(int roomCode, List<Integer> memberList){
        memberList.stream().forEach(memberCode ->{
            memberRepository.findById(memberCode)
                    .orElseThrow(()-> new NotFindDataException("유저를 찾을 수 없습니다."));
            ChatRoomMemberRepository.save(new ChatRoomMember(memberCode, roomCode));
        });
    }

    public void leaveRoom(int roomCode, int memberCode) {
//        ChatRoom chatRoom = findByChatRoom(roomCode);
//        chatRoom.getChatRoomMemberList().stream().filter(chatRoomMember -> chatRoomMember.getMemberCode() != memberCode);

        ChatRoomMemberRepository.delete(new ChatRoomMember(memberCode, roomCode));

    }

    public List<ChatRoomDTO> findByChatRoomList(int memberCode) {

        List<ChatRoom> chatRoomList = chatRoomRepository.findAllByChatroom(memberCode);


        return chatRoomList.stream()
                .map(chatRoom ->
                        modelMapper.map(chatRoom, ChatRoomDTO.class))
                .collect(Collectors.toList());
    }
}
