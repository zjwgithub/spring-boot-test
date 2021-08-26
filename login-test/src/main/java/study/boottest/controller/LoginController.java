package study.boottest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import study.boottest.Const;
import study.boottest.CookieUtil;
import study.boottest.repository.Member;
import study.boottest.repository.MemberRepository;
import study.boottest.service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static study.boottest.Const.*;
import static study.boottest.CookieUtil.*;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm loginForm) {
        return "home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm,
                        BindingResult bindingResult,
                        HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            System.out.println("bindingResult = " + bindingResult);
            return "home";
        }

        Member member = memberRepository.findByLoginId(loginForm.getLoginId()).orElse(null);
        if (member == null) {
            System.out.println("member null");
            bindingResult.reject("member null");
            return "home";
        }

        Cookie cookie = new Cookie(LOGIN_COOKIE_NAME, String.valueOf(member.getId()));
        response.addCookie(cookie);
        
        return "redirect:/";
    }
    
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie(LOGIN_COOKIE_NAME, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
