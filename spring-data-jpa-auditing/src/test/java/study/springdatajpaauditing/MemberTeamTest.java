package study.springdatajpaauditing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.springdatajpaauditing.domain.Member;
import study.springdatajpaauditing.domain.Team;
import study.springdatajpaauditing.repository.MemberRepository;
import study.springdatajpaauditing.repository.TeamRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

@SpringBootTest
@Transactional
@Commit
public class MemberTeamTest {

    @Autowired
    MemberRepository memberRepository;
    
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    EntityManager em;

    @Test
    void memberTest() throws InterruptedException {
        Member member = memberRepository.save(new Member("member1"));
        System.out.println("member = " + member);
        System.out.println("member.getCreatedDate()      = " + member.getCreatedDate());
        System.out.println("member.getLastModifiedDate() = " + member.getLastModifiedDate());
        System.out.println("member.getCreatedBy()        = " + member.getCreatedBy());
        System.out.println("member.getLastModifiedBy()   = " + member.getLastModifiedBy());

        Thread.sleep(100);

        member.setName("MEMBER 1 updated");

        em.flush();
        em.clear();

        member = memberRepository.findById(member.getId()).get();
        System.out.println("member = " + member);
        System.out.println("member.getCreatedDate()      = " + member.getCreatedDate());
        System.out.println("member.getLastModifiedDate() = " + member.getLastModifiedDate());
        System.out.println("member.getCreatedBy()        = " + member.getCreatedBy());
        System.out.println("member.getLastModifiedBy()   = " + member.getLastModifiedBy());
    }

    @Test
    void teamTest() throws InterruptedException {
        Team team = teamRepository.save(new Team("team1"));
        System.out.println("team = " + team);

        Thread.sleep(100);
        
        team.setName("TEAM 1 updated");
        
        em.flush();
        em.clear();

        team = teamRepository.findById(team.getId()).get();
        System.out.println("team = " + team);
    }
}
