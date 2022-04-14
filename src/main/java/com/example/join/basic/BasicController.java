package com.example.join.basic;


import com.example.join.basic.member.Member;
import com.example.join.basic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic")
@RequiredArgsConstructor
public class BasicController {

    private final MemberRepository memberRepository;

    @GetMapping("/member/{memberId}")
    public String member(@PathVariable String memberId, Model model) {
        Member findMember = memberRepository.findById(memberId);
        model.addAttribute("member", findMember);
        return "basic/member";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "basic/members";
    }

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("member", new Member());
        return "basic/join";
    }

    @PostMapping("/join")
    public String join(@RequestParam Member member, Model model) {
        Member savedMember = memberRepository.save(member);
        model.addAttribute("member", savedMember);
        return "basic/member";
    }
}
