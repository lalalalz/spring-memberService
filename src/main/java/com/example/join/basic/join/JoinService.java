package com.example.join.basic.join;

import com.example.join.basic.form.MemberJoinForm;
import com.example.join.basic.member.Member;
import com.example.join.basic.member.MemberAuthority;
import com.example.join.basic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberRepository memberRepository;

    public Member doJoin(MemberJoinForm memberJoinForm) {
        memberJoinForm.setAuthority(MemberAuthority.USER);
        Member newMember = new Member(memberJoinForm);
        memberRepository.save(newMember);
        return newMember;
    }
}
