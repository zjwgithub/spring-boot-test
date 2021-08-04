package my.study.springbootaoptest.controller.member;

import lombok.RequiredArgsConstructor;
import my.study.springbootaoptest.service.member.MemberService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    public void getName(String nickName, Integer age) {
        System.out.println("MemberController.getName()");
        String name = memberService.getName();
        System.out.println("member name = " + name);
    }

    public void error() {
        memberService.error();
    }
}
