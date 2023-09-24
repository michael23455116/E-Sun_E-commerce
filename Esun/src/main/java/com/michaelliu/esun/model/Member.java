package com.michaelliu.esun.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Member {
    private Integer memberid;
    private String email;
    @JsonIgnore
    private String password;
}
