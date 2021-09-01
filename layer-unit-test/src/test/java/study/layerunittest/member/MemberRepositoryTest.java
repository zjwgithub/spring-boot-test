package study.layerunittest.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
@Commit
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    
    @Test
    void beforeEach() {
        memberRepository.deleteAll();
    }

    @Test
    void notNull() {
        assertThat(memberRepository).isNotNull();
    }

    @Test
    void save() {
        Member memberA = new Member("memberA", 10);

        Member saveMember = memberRepository.save(memberA);
        
        assertThat(saveMember).isEqualTo(memberA);
    }

    @Test
    void findByName() {
        
    }

    @Test
    void update() {
        Member memberA = new Member("memberA", 10);
        Member saveMemberA = memberRepository.save(memberA);

        memberA.setName("memberB");
        memberA.setAge(20);
        Member saveMember = memberRepository.save(memberA);

        Member findMember = memberRepository.findById(saveMember.getId())
                .orElse(null);

        assertThat(findMember.getName()).isEqualTo("memberB");
        assertThat(findMember.getAge()).isEqualTo(20);
    }

    @Test
    void deleteById() {
        Member memberA = new Member("memberA", 10);
        Member memberB = new Member("memberB", 20);
        Member memberC = new Member("memberC", 30);

        Member saveMemberA = memberRepository.save(memberA);
        Member saveMemberB = memberRepository.save(memberB);
        Member saveMemberC = memberRepository.save(memberC);
        
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(3);
        
        memberRepository.deleteById(saveMemberA.getId());

        members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(memberB, memberC);
    }
}