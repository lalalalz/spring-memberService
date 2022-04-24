package com.example.join.basic.form;

import com.example.join.basic.member.Member;
import com.example.join.basic.member.MemberAuthority;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberForm {

    private String memberId;
    private String memberName;
    private Integer age;
    private String email;

    private Integer[] farms;
    private MemberAuthority authority;

    public MemberForm() {
    }

    public MemberForm(Member member) {
        this.setMemberId(member.getMemberId());
        this.setMemberName(member.getMemberName());
        this.setAge(member.getAge());
        this.setEmail(member.getEmail());
        this.setFarms(member.getFarms());
        this.setAuthority(member.getAuthority());
    }
}
