package study.boottest.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import study.boottest.domain.LoginService;
import study.boottest.domain.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    
    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request, Model model) {
        log.info("login loginForm={}", loginForm);
        if (bindingResult.hasErrors()) {
            log.info("bindingResult={}", bindingResult);
            return "loginForm";
        }
        Member member = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        if (member == null) {
            log.info("member not found");
            bindingResult.reject("member not found");
            return "loginForm";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("mySessionId", member.getId());
        session.setAttribute("mySessionNm", member.getName());
        
        model.addAttribute("member", member);

        return "redirect:/";
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
