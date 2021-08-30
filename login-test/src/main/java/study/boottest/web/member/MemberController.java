package study.boottest.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import study.boottest.domain.member.Member;
import study.boottest.domain.member.MemberRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    
    @GetMapping("/members")
    public String members(@SessionAttribute("loginMember") Member loginMember,
                          @SessionAttribute("loginMemberAge") Integer loginMemberAge,
                          HttpServletRequest request, Model model) {
        
        List<Member> members = memberRepository.findAll();
        
        model.addAttribute("members", members);
        model.addAttribute("loginMember", loginMember);
        model.addAttribute("loginMemberAge", loginMemberAge);
        
        return "members";
    }
    
}
