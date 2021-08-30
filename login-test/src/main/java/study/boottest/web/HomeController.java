package study.boottest.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import study.boottest.domain.member.Member;
import study.boottest.domain.member.MemberRepository;
import study.boottest.web.login.LoginForm;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String home(@SessionAttribute(value = "loginMember", required = false) Member loginMember,
                       @SessionAttribute(value = "loginMemberAge", required = false) Integer loginMemberAge,
                       @ModelAttribute("loginForm") LoginForm loginForm,
                       Model model) {

        if (loginMember == null || memberRepository.findById(loginMember.getId()) == null) {
            log.info("session not valid");
            return "redirect:login";
        }
        
        model.addAttribute("loginMember", loginMember);
        model.addAttribute("loginMemberAge", loginMemberAge);

        return "loginDone";
    }

}
