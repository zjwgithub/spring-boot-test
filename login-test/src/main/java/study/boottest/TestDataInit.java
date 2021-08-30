package study.boottest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.boottest.domain.member.Member;
import study.boottest.domain.member.MemberRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;
    
    @PostConstruct
    public void init() {
        memberRepository.save(new Member("test1", "testA", 10, "test!"));
        memberRepository.save(new Member("test2", "testB", 20, "test!"));
        memberRepository.save(new Member("test3", "testC", 30, "test!"));
    }
}
