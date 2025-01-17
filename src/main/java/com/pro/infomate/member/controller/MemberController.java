package com.pro.infomate.member.controller;

import com.pro.infomate.common.ResponseDTO;
import com.pro.infomate.member.dto.MemberDTO;
import com.pro.infomate.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "회원 조회 요청", description = "회원 한명이 조회됩니다.", tags = { "MemberController" })
    @GetMapping("/members/{memberId}")
    public ResponseEntity<ResponseDTO> selectMyMemberInfo(@PathVariable String memberId){

        log.info("[MemberController]  selectMyMemberInfo   Start =============== ");
        log.info("[MemberController]  selectMyMemberInfo   {} ====== ", memberId);

        log.info("[MemberController]  selectMyMemberInfo   End ================= ");
        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.OK, "조회 성공", memberService.selectMyInfo(memberId)));
    }

    @GetMapping("/userinfo")
    public ResponseEntity<Map<String, Object>> serverUserInfo(@AuthenticationPrincipal MemberDTO memberDTO){
        log.info("[MemberController](serverUserInfo) memberDTO : {}", memberDTO);
        Map<String, Object> result = new HashMap<>();
        result.put("memberCode", memberDTO.getMemberCode());
        result.put("memberName", memberDTO.getMemberName());

        log.info("[MemberController](serverUserInfo) result : {}", result);

        return  ResponseEntity.ok(result);
    }
}
