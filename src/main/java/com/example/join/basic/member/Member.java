package com.example.join.basic.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Member {

    private String memberId;
    private String password;

    private String memberName;
    private Integer age;
    private String email;

    public Member(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }

    public Member() {
    }
}

