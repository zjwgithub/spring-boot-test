package study.boottest.web.interceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import study.boottest.domain.member.Member;
import study.boottest.domain.member.MemberRepository;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    private final MemberRepository memberRepository;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        printRequest(request, "preHandle");

        try {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("loginMember") == null) {
                throw new IllegalStateException("session not valid");
            }

            Member loginMember = (Member) session.getAttribute("loginMember");
            Member findMember = memberRepository.findById(loginMember.getId());
            if (findMember == null) {
                throw new IllegalStateException("loginMember not found in repository");
            }
        } catch (IllegalStateException e) {
            printRequest(request, "preHandle", e.getMessage());
            response.sendRedirect("/login?redirectURL=" + request.getRequestURI());
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        printRequest(request, "postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        printRequest(request, "afterCompletion");
    }

    private void printRequest(HttpServletRequest request, String methodName) {
        printRequest(request, methodName, "");
    }
    private void printRequest(HttpServletRequest request, String methodName, String msg) {
        DispatcherType dispatcherType = request.getDispatcherType();
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        log.info(methodName + " [{}][{}][{}][{}]", dispatcherType, method, requestURI, msg);
    }
    
}
