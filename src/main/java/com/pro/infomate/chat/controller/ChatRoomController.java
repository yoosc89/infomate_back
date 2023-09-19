package com.pro.infomate.chat.controller;

import com.pro.infomate.chat.dto.ChatRoomDTO;
import com.pro.infomate.chat.service.ChatRoomService;
import com.pro.infomate.common.ResponseDTO;
import com.pro.infomate.member.dto.MemberDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping("/room/{roomCode}")
    public ResponseEntity<ResponseDTO> findByChatRoomCode(@PathVariable int roomCode){

        log.info("[ChatRoomController](findByChatRoomCode) roomCode : {}", roomCode);
        return ResponseEntity.ok().body(
                ResponseDTO.builder()
                        .status(HttpStatus.OK)
                        .message("성공적으로 불어왔습니다.")
                        .data(chatRoomService.findByChatRoomCode(roomCode))
                        .build()
                );
    }


    @PatchMapping("/room/{roomCode}")
    public ResponseEntity<ResponseDTO> updateByChatRoom(@PathVariable int roomCode, @RequestBody ChatRoomDTO chatRoomDTO){

        chatRoomService.updateByChatroom(roomCode, chatRoomDTO);

        return ResponseEntity.ok(ResponseDTO.builder()
                        .message("수정을 완료 했습니다.")
                        .build()
        );

    }


    @DeleteMapping("/room/{roomCode}")
    public ResponseEntity<ResponseDTO> leaveRoom(@PathVariable int roomCode, @AuthenticationPrincipal MemberDTO memberDTO){
        chatRoomService.leaveRoom(roomCode, memberDTO.getMemberCode());
        return ResponseEntity.ok(ResponseDTO.builder()
                        .message("정상적으로 처리되었습니다.")
                        .build()
        );
    }
}
