package my.study.springbootaoptest.service.member;

import lombok.RequiredArgsConstructor;
import my.study.springbootaoptest.repository.member.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String getName() {
        System.out.println("MemberService.getName()");
        return memberRepository.getName();
    }

    public void error() {
        memberRepository.error();
    }
}
