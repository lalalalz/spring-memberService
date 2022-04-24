package com.example.join.basic.login;

import com.example.join.basic.form.MemberLoginForm;
import com.example.join.basic.member.Member;
import com.example.join.basic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public boolean doLogin(MemberLoginForm memberLoginForm) {

        String paramMemberId = memberLoginForm.getMemberId();
        String paramPassword = memberLoginForm.getPassword();

        Member findMember = memberRepository.findById(paramMemberId);

        if(findMember != null) {

            String memberId = findMember.getMemberId();
            String password = findMember.getPassword();

            if (memberId.equals(paramMemberId) && password.equals(paramPassword)) {
                log.info("로그인 성공!");
                return true;
            }
        }

        log.info("로그인 실패!");
        return false;
    }
}
