package com.example.join.basic.member;

import com.example.join.basic.form.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @ModelAttribute("memberAuthority")
    public MemberAuthority[] memberAuthority() {
        return MemberAuthority.values();
    }

    // 회원 상세 조회
    @GetMapping("/{memberId}")
    public String member(@PathVariable String memberId, Model model) {
        Member findMember = memberRepository.findById(memberId);
        MemberForm memberForm = new MemberForm(findMember);
        model.addAttribute("member", memberForm);
        return "basic/member";
    }

    // 회원 목록 조회
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "basic/members";
    }
}
