package com.michaelliu.esun.dao;

import com.michaelliu.esun.dto.MemberRegisterRequest;
import com.michaelliu.esun.model.Member;

public interface MemberDao {
    Integer createUser(MemberRegisterRequest userRegisterRequest);
    Member getUserById(Integer memberid);
    Member getUserByEmail(String email);
}
