package com.pro.infomate.chat.service;


import com.pro.infomate.chat.dto.ChatRoomDTO;
import com.pro.infomate.chat.entity.ChatRoom;
import com.pro.infomate.chat.repository.ChatRoomRepository;
import com.pro.infomate.exception.NotFindDataException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    private final ModelMapper modelMapper;

    private ChatRoom findByChatRoom(int roomCode){
        ChatRoom chatRoom = chatRoomRepository.findById(roomCode)
                .orElseThrow(()-> new NotFindDataException("채팅방을 찾을 수 없습니다."));
        return chatRoom;
    }

    public ChatRoomDTO findByChatRoomCode(int roomCode) {

        ChatRoom chatRoom = findByChatRoom(roomCode);

        ChatRoomDTO chatRoomDTO = modelMapper.map(chatRoom, ChatRoomDTO.class);

        return chatRoomDTO;

    }

    public void updateByChatroom(int roomCode, ChatRoomDTO chatRoomDTO) {

        ChatRoom chatRoom = findByChatRoom(roomCode);


        // 수정 로직

    }

    public void leaveRoom(int roomCode, int memberCode) {
        ChatRoom chatRoom = findByChatRoom(roomCode);


        chatRoom.getChatRoomMemberList().stream().filter(chatRoomMember -> chatRoomMember.getMemberCode() != memberCode);
    }
}
