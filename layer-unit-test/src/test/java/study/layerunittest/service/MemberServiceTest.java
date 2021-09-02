package study.layerunittest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.layerunittest.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@Commit
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    
    @Autowired
    EntityManager em;
    
    @BeforeEach
    void beforeEach() {
        memberService.deleteAll();
    }

    @Test
    void save() {
        Member memberA = new Member("myLoginId1", "myLoginId!", "memberA", 10);

        Long saveId = memberService.save(memberA);

        Member findMember = memberService.findById(saveId).get();
        assertThat(findMember).isEqualTo(memberA);
    }

    @Test
    void findMembers() {
        Member memberA = new Member("myLoginId1", "myLoginId!", "memberA", 10);
        Member memberB = new Member("myLoginId2", "myLoginId!", "memberB", 20);
        memberService.save(memberA);
        memberService.save(memberB);

        List<Member> members = memberService.findMembers();
        
        assertThat(members).hasSize(2);
        assertThat(members).containsExactly(memberA, memberB);
    }

    @Test
    void findById() {
        Member memberA = new Member("myLoginId1", "myLoginId!", "memberA", 10);
        Member memberB = new Member("myLoginId2", "myLoginId!", "memberB", 20);
        memberService.save(memberA);
        memberService.save(memberB);

        Member findMember = memberService.findById(memberA.getId()).get();

        assertThat(findMember).isEqualTo(memberA);
    }

    @Test
    void updatePassword() {
        Member memberA = new Member("myLoginId1", "myLoginId!", "memberA", 10);
        Member memberB = new Member("myLoginId2", "myLoginId!", "memberB", 20);
        memberService.save(memberA);
        memberService.save(memberB);

        Member updateMember = new Member(null, "1234", null, null);
        memberService.changePassword(memberA.getId(), updateMember);

        Member findMember = memberService.findById(memberA.getId()).get();
        assertThat(findMember.getPassword()).isEqualTo("1234");
    }

    @Test
    void deleteById() {
        Member memberA = new Member("myLoginId1", "myLoginId!", "memberA", 10);
        Member memberB = new Member("myLoginId2", "myLoginId!", "memberB", 20);
        memberService.save(memberA);
        memberService.save(memberB);
        
        memberService.deleteById(memberA.getId());

        Optional<Member> optionalMember = memberService.findById(memberA.getId());
        assertThat(optionalMember).isEqualTo(Optional.empty());

    }

    @Test
    void deleteAll() {
        Member memberA = new Member("myLoginId1", "myLoginId!", "memberA", 10);
        Member memberB = new Member("myLoginId2", "myLoginId!", "memberB", 20);
        memberService.save(memberA);
        memberService.save(memberB);

        memberService.deleteAll();

        List<Member> members = memberService.findMembers();
        assertThat(members).hasSize(0);
        assertThat(members.size()).isEqualTo(0);
    }

    @Test
    void increaseAge() {
        Member memberA = new Member("myLoginId1", "myLoginId!", "memberA", 10);
        Member memberB = new Member("myLoginId2", "myLoginId!", "memberB", 20);
        memberService.save(memberA);
        memberService.save(memberB);

        memberService.increaseAge(1);
        em.flush();
        em.clear();
        
        Member findMemberA = memberService.findById(memberA.getId()).orElse(null);
        Member findMemberB = memberService.findById(memberB.getId()).orElse(null);
        assertThat(findMemberA.getAge()).isEqualTo(11);
        assertThat(findMemberB.getAge()).isEqualTo(21);
    }
}