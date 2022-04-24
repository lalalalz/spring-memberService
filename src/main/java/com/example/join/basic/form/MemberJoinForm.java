package com.example.join.basic.form;

import com.example.join.basic.member.MemberAuthority;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberJoinForm {

    private String memberId;
    private String password;

    private String memberName;
    private Integer age;
    private String email;

    private Integer[] farms;
    private MemberAuthority authority;

    public MemberJoinForm() {

    }

}
