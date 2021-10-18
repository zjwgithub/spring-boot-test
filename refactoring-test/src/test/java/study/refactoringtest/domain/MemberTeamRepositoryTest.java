package study.refactoringtest.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.refactoringtest.domain.member.Member;
import study.refactoringtest.domain.member.MemberRepository;
import study.refactoringtest.domain.team.Team;
import study.refactoringtest.domain.team.TeamRepository;

@SpringBootTest
@Transactional
@Commit
class MemberTeamRepositoryTest {
    
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MemberTeamRepository memberTeamRepository;

    @Test
    void member() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        Team teamC = new Team("teamC");
        teamRepository.save(teamA);
        teamRepository.save(teamB);
        teamRepository.save(teamC);

        Member memberA = new Member("member1", 14);
        Member memberB = new Member("member2", 20);
        Member memberC = new Member("member3", 17);
        Member memberD = new Member("member4", 22);
        Member memberE = new Member("member5", 16);
        Member memberF = new Member("member6", 26);
        memberRepository.save(memberA);
        memberRepository.save(memberB);
        memberRepository.save(memberC);
        memberRepository.save(memberD);
        memberRepository.save(memberE);
        memberRepository.save(memberF);

        MemberTeam memberTeam1 = memberTeamRepository.save(new MemberTeam(teamA, memberA));
        MemberTeam memberTeam2 = memberTeamRepository.save(new MemberTeam(teamA, memberB));
        MemberTeam memberTeam3 = memberTeamRepository.save(new MemberTeam(teamA, memberC));
        MemberTeam memberTeam4 = memberTeamRepository.save(new MemberTeam(teamB, memberD));
        MemberTeam memberTeam5 = memberTeamRepository.save(new MemberTeam(teamB, memberE));

        String username = memberTeam1.getMember().getUsername();
        System.out.println("username = " + username);
    }
}
