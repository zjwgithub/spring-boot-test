package study.springbootcompositeprimarykey.idclass;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class IdclassTest {

    @Autowired
    EntityManager em;

    @Test
    @Commit
    void test1() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 11);
        Member member2 = new Member("member2", 22);
        Member member3 = new Member("member3", 33);
        Member member4 = new Member("member4", 44);
        Member member5 = new Member("member5", 55);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
        em.persist(member5);

        em.persist(new TeamMember(teamA.getId(), member1.getId()));
        em.persist(new TeamMember(teamA.getId(), member2.getId()));
        em.persist(new TeamMember(teamB.getId(), member3.getId()));
        em.persist(new TeamMember(teamB.getId(), member4.getId()));
        em.persist(new TeamMember(teamB.getId(), member5.getId()));
    }
}
