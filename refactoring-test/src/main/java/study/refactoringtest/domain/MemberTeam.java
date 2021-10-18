package study.refactoringtest.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.refactoringtest.domain.member.Member;
import study.refactoringtest.domain.team.Team;

import javax.persistence.*;

@Getter
@Entity
@IdClass(MemberTeamId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberTeam {
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    public MemberTeam(Team team, Member member) {
        this.team = team;
        this.member = member;
    }
}
