package study.jpaauditing.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
@Commit
class MemberJpaRepositoryTest {
    
    @Autowired
    MemberJpaRepository memberJpaRepository;
    
    @Autowired
    EntityManager em;

    @Test
    void auditingTest() throws InterruptedException {
        Member member = memberJpaRepository.save(new Member("member1"));
        System.out.println("member Created = " + member);
        
        Thread.sleep(100);
        
        member.setName("MEMBER 1 updated");
        
        em.flush();
        em.clear();

        member = memberJpaRepository.findById(member.getId()).get();
        System.out.println("member Updated = " + member);
    }
}