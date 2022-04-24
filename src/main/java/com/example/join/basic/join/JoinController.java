package com.example.join.basic.join;

import com.example.join.basic.form.MemberJoinForm;
import com.example.join.basic.member.Member;
import com.example.join.basic.member.MemberAuthority;
import com.example.join.basic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/join")
@RequiredArgsConstructor
public class JoinController {

    private final MemberRepository memberRepository;
    private final JoinService joinService;

    @GetMapping
    public String joinForm(Model model) {
        model.addAttribute("member", new MemberJoinForm());
        return "basic/join";
    }

    @PostMapping
    public String join(@ModelAttribute MemberJoinForm memberJoinForm, RedirectAttributes redirectAttributes) {
        Member newMember = joinService.doJoin(memberJoinForm);
        log.info("join={}", newMember);

        redirectAttributes.addAttribute("memberId", newMember.getMemberId());
        return "redirect:/members/{memberId}";
    }
}
