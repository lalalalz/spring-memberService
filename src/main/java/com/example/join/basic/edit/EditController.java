package com.example.join.basic.edit;

import com.example.join.basic.form.MemberForm;
import com.example.join.basic.member.Member;
import com.example.join.basic.member.MemberAuthority;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/edit")
@RequiredArgsConstructor
public class EditController {

    private final EditService editService;

    @ModelAttribute("memberAuthority")
    public MemberAuthority[] memberAuthority() {
        return MemberAuthority.values();
    }


    @GetMapping("/{memberId}")
    public String editForm(@PathVariable String memberId, Model model) {
        MemberForm memberForm = editService.getEditMember(memberId);
        model.addAttribute("member", memberForm);
        return "basic/edit";
    }

    @PostMapping("/{memberId}")
    public String edit(@PathVariable String memberId, @ModelAttribute MemberForm memberForm, RedirectAttributes redirectAttributes) {
        MemberForm editMember = editService.doEdit(memberId, memberForm);
        redirectAttributes.addAttribute("memberId", memberId);
        return "redirect:/members/{memberId}";
    }
}
