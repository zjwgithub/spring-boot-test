package study.boottest.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import study.boottest.domain.Member;
import study.boottest.domain.MemberRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    
    @GetMapping("/")
    public String loginHome(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("mySessionId") == null) {
            log.info("session not found");
            return "home";
        }

        Long mySessionId = (Long) session.getAttribute("mySessionId");
        String mySessionNm = String.valueOf(session.getAttribute("mySessionNm"));
        Member member = memberRepository.findById(mySessionId);
        if (member == null) {
            return "home";
        }
        
        model.addAttribute("member", member);
        return "loginHome";
    }
}
