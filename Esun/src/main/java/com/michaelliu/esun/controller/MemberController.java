package com.michaelliu.esun.controller;

import com.michaelliu.esun.dto.MemberLoginRequest;
import com.michaelliu.esun.dto.MemberRegisterRequest;
import com.michaelliu.esun.model.Member;
import com.michaelliu.esun.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService userService;

    @PostMapping("/members/register")
    public ResponseEntity<Member> register(@RequestBody @Valid MemberRegisterRequest userRegisterRequest){
        Integer memberid = userService.register(userRegisterRequest);
        Member user =userService.getUserById(memberid);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/members/login")
    public ResponseEntity<Member> login(@RequestBody @Valid MemberLoginRequest userLoginRequest){
        Member user = userService.login(userLoginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
