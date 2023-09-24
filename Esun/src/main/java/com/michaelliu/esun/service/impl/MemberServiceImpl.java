package com.michaelliu.esun.service.impl;


import com.michaelliu.esun.dao.MemberDao;
import com.michaelliu.esun.dto.MemberLoginRequest;
import com.michaelliu.esun.dto.MemberRegisterRequest;
import com.michaelliu.esun.model.Member;
import com.michaelliu.esun.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemberServiceImpl implements MemberService {

    private final static Logger log= LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberDao userDao;

    @Override
    public Member getUserById(Integer memberid) {
        return userDao.getUserById(memberid);
    }

    @Override
    public Integer register(MemberRegisterRequest userRegisterRequest) {
        //檢查註冊的email
        Member user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if(user!=null){
            log.warn("該email {} 已經被註冊",userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //使用MD5生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);

        //創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public Member login(MemberLoginRequest userLoginRequest) {
        Member user = userDao.getUserByEmail(userLoginRequest.getEmail());

        //檢查user是否存在
        if(user == null){
            log.warn("該email{}尚未註冊",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //使用MD5生成密碼的雜湊值，MD5已被彩虹表破解，透過加鹽反制
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        //比較密碼
        if(user.getPassword().equals(hashedPassword)){
            return user;
        }else {
            log.warn("email{}密碼不正確！",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
