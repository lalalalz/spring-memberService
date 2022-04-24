package com.example.join.basic.login;

import com.example.join.basic.form.MemberLoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String loginForm(Model model) {
        model.addAttribute("member", new MemberLoginForm());
        return "basic/login";
    }

    @PostMapping
    public String login(@ModelAttribute MemberLoginForm memberLoginForm, RedirectAttributes redirectAttributes) {
        if (loginService.doLogin(memberLoginForm)) return "redirect:/members";
        redirectAttributes.addAttribute("status", true);
        return "redirect:/login";
    }
}
