package study.boottest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.boottest.domain.Member;
import study.boottest.domain.MemberRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;
    
    @PostConstruct
    public void init() {
        memberRepository.save(new Member("test1", "테스트1", "test!"));
        memberRepository.save(new Member("test2", "테스트2", "test!"));
        memberRepository.save(new Member("test3", "테스트3", "test!"));
    }
}
