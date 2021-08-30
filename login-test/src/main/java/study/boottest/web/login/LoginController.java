package study.boottest.web.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.boottest.domain.login.LoginService;
import study.boottest.domain.member.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, 
                        BindingResult bindingResult, 
                        @RequestParam(name = "redirectURL", defaultValue = "/") String redirectURL,
                        HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "loginForm";
        }
        
        Member member = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        if (member == null) {
            bindingResult.reject("loginFail", "member not found");
            bindingResult.reject("errMsg1", "에러1 발생");
            bindingResult.reject("errMsg2", "에러2 발생");
            return "loginForm";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("loginMember", member);
        session.setAttribute("loginMemberAge", member.getAge());
        
        return "redirect:" + redirectURL;
    }
    
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
    
}
