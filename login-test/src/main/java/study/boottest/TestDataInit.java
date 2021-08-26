package study.boottest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.boottest.repository.Member;
import study.boottest.repository.MemberRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    
    private final MemberRepository memberRepository;
    
    @PostConstruct
    public void init() {
        memberRepository.save(new Member("test1", "test!"));
        memberRepository.save(new Member("test2", "test!"));
        memberRepository.save(new Member("test3", "test!"));
    }
    
}
