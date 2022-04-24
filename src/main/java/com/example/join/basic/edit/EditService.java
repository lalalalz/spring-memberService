package com.example.join.basic.edit;

import com.example.join.basic.form.MemberForm;
import com.example.join.basic.member.Member;
import com.example.join.basic.member.MemberAuthority;
import com.example.join.basic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Service
@RequiredArgsConstructor
public class EditService {

    private final MemberRepository memberRepository;

    public MemberForm getEditMember(String memberId) {
        Member findMember = memberRepository.findById(memberId);
        MemberForm memberForm = new MemberForm(findMember);
        return memberForm;
    }

    public MemberForm doEdit(String memberId, MemberForm memberForm) {
        memberRepository.update(memberId, memberForm);
        return memberForm;
    }
}
