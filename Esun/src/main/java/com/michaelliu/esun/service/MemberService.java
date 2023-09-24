package com.michaelliu.esun.service;

import com.michaelliu.esun.dto.MemberLoginRequest;
import com.michaelliu.esun.dto.MemberRegisterRequest;
import com.michaelliu.esun.model.Member;

public interface MemberService {
    Integer register(MemberRegisterRequest userRegisterRequest);
    Member getUserById(Integer memberid);
    Member login(MemberLoginRequest userLoginRequest);
}
