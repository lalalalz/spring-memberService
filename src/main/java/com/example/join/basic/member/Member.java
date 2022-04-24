package com.example.join.basic.member;

import com.example.join.basic.form.MemberJoinForm;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

    private String memberId;
    private String password;

    private String memberName;
    private Integer age;
    private String email;

    private Integer[] farms;
    private MemberAuthority authority;

    public Member(MemberJoinForm memberJoinForm) {
        this.memberId = memberJoinForm.getMemberId();
        this.password = memberJoinForm.getPassword();
        this.memberName = memberJoinForm.getMemberName();
        this.age = memberJoinForm.getAge();
        this.email = memberJoinForm.getEmail();
        this.farms = memberJoinForm.getFarms();
        this.authority = memberJoinForm.getAuthority();
    }

    public Member(String memberName, Integer age, String email, Integer[] farms, MemberAuthority authority) {
        this.memberName = memberName;
        this.age = age;
        this.email = email;
        this.farms = farms;
        this.authority = authority;
    }

    public Member(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }

    public Member() {
    }
}

