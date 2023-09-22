package com.pro.infomate.chat.controller;

import com.pro.infomate.chat.dto.ChatRoomDTO;
import com.pro.infomate.chat.service.ChatRoomService;
import com.pro.infomate.common.ResponseDTO;
import com.pro.infomate.member.dto.MemberDTO;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @GetMapping("/roomlist")
    public ResponseEntity<ResponseDTO> findBdyChatRoomList(@AuthenticationPrincipal MemberDTO memberDTO){

        log.info("[ChatRoomController](findBdyChatRoomList) start");
        return ResponseEntity.ok().body(ResponseDTO.builder()
                .status(HttpStatus.OK)
                .message("불러오기 성공")
                .data(chatRoomService.findByChatRoomList(memberDTO.getMemberCode()))
                .build());
    }

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


    @PostMapping("/room/regist")
    public ResponseEntity<ResponseDTO> registChatroom(@RequestBody List<Integer> memberList,
                                                      @AuthenticationPrincipal MemberDTO memberDTO){

        log.info("[ChatRoomController](registChatroom) memberList : {}", memberList);
        memberList.add(memberDTO.getMemberCode());

        return ResponseEntity.ok()
                .body(ResponseDTO.builder()
                        .status(HttpStatus.OK)
                        .message("성공적으로 생성되었습니다.")
                        .data(chatRoomService.registChatRooms(memberList))
                        .build()
                );
    }

    @PatchMapping("/room/addmember/{roomCode}")
    public ResponseEntity<ResponseDTO> addMemberChatroom(@PathVariable int roomCode, @RequestBody List<Integer> memberList){
        log.info("[ChatRoomController](registChatroom) memberList : {}", memberList);
        chatRoomService.addRoomMember(roomCode, memberList);
        return ResponseEntity.ok()
                .body(ResponseDTO.builder()
                        .message("성공적으로 추가되었습니다.")
                        .build());
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
