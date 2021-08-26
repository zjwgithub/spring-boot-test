package study.boottest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import study.boottest.Const;
import study.boottest.CookieUtil;
import study.boottest.repository.Member;
import study.boottest.repository.MemberRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static study.boottest.CookieUtil.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    
    @GetMapping("/")
    public String loginHome(HttpServletRequest request, Model model) {
        Cookie cookie = getCookie(request, Const.LOGIN_COOKIE_NAME);
        if (cookie == null || cookie.getValue() == null) {
            return "home";
        }
        Member member = memberRepository.findById(Long.parseLong(cookie.getValue()));
        if (member == null) {
            return "home";
        }
        model.addAttribute("member", member);
        return "loginHome";
    }

}
