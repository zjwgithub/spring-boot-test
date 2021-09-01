package study.layerunittest.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberJpaRepositoryBootTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;
    
    @Autowired
    EntityManager em;

    @Test
    void notNull() {
        assertThat(memberJpaRepository).isNotNull();
    }

    @Test
    @Transactional
    @Commit
    void save() {
        Member memberA = new Member("memberA", 10);
        
        Member saveMember = memberJpaRepository.save(memberA);

        Member findMember = memberJpaRepository.findById(memberA.getId());

        assertThat(findMember).isEqualTo(memberA);
    }

    @Test
    @Transactional
    @Commit
    void findByName() {
        Member memberA = new Member("memberA", 10);

        Member saveMember = memberJpaRepository.save(memberA);

        List<Member> findMembers = memberJpaRepository.findByName("memberA");

        assertThat(findMembers.size()).isEqualTo(1);
        assertThat(findMembers.get(0)).isEqualTo(memberA);
    }

    @Test
    @Transactional
    @Commit
    void update() {
        Member memberA = memberJpaRepository.save(new Member("memberA", 10));

        memberA.setName("AA");
        memberA.setAge(11);
    }

    @Test
    @Transactional
    @Commit
    void update2() {
        Member memberA = memberJpaRepository.save(new Member("memberA", 10));
        Member memberAA = new Member("AA", 11);
        Long memberId = memberA.getId();

        memberJpaRepository.update(memberA.getId(), memberAA);
        em.flush();
        em.clear();
        
        Member findMember = memberJpaRepository.findById(memberId);
        System.out.println("findMember = " + findMember);
        assertThat(findMember.getName()).isEqualTo("AA");
        assertThat(findMember.getAge()).isEqualTo(11);
    }

    @Test
    @Transactional
    @Commit
    void deleteById() {
        Member memberA = memberJpaRepository.save(new Member("memberA", 10));
        Member memberB = memberJpaRepository.save(new Member("memberB", 20));
        Member memberC = memberJpaRepository.save(new Member("memberC", 30));
        List<Member> findMembers = memberJpaRepository.findAll();
        assertThat(findMembers.size()).isEqualTo(3);
        assertThat(findMembers).containsExactly(memberA, memberB, memberC);

        memberJpaRepository.deleteById(memberA.getId());

        findMembers = memberJpaRepository.findAll();
        assertThat(findMembers.size()).isEqualTo(2);
        assertThat(findMembers).containsExactly(memberB, memberC);
    }
}