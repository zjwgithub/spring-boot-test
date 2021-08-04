package my.study.springbootaoptest.repository.member;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    public String getName() {
        System.out.println("MemberRepository.getName()");
        return "apple";
    }

    public void error() {
        throw new IllegalStateException("memberRepository error");
    }
}
