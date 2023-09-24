package com.michaelliu.esun.dao.Impl;

import com.michaelliu.esun.dao.MemberDao;
import com.michaelliu.esun.dto.MemberRegisterRequest;
import com.michaelliu.esun.model.Member;
import com.michaelliu.esun.rowmapper.MemberRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Member getUserById(Integer memberid) {
        String sql ="SELECT memberid,password,email " +
                "FROM member WHERE memberid=:memberid";
        Map<String ,Object> map = new HashMap<>();
        map.put("memberid",memberid);
        List<Member> memberList = namedParameterJdbcTemplate.query(sql,map,new MemberRowMapper());
        if (memberList.size()>0){
            return memberList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Member getUserByEmail(String email) {
        String sql = "SELECT memberid,email,password " +
                "FROM member " +
                "WHERE email =:email";
        Map<String ,Object> map = new HashMap<>();
        map.put("email",email);
        List<Member> memberList = namedParameterJdbcTemplate.query(sql,map,new MemberRowMapper());
        if(memberList.size()>0){
            return memberList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Integer createUser(MemberRegisterRequest memberRegisterRequest) {
        String sql="INSERT INTO member(email,password) " +
                "VALUES(:email,:password)";
        Map<String ,Object> map = new HashMap<>();
        map.put("email",memberRegisterRequest.getEmail());
        map.put("password",memberRegisterRequest.getPassword());

        KeyHolder keyHolder= new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        int memberid = keyHolder.getKey().intValue();
        return memberid;
    }
}
