package study.springboottestannotationtest.service;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public String hello() {
        return "hello member";
    }
}
