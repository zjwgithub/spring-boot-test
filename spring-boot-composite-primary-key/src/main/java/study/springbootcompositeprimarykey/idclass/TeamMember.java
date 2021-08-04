package study.springbootcompositeprimarykey.idclass;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TeamMemberId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamMember {

    @Id
    private Long teamId;

    @Id
    private Long memberId;

    public TeamMember(Long teamId, Long memberId) {
        this.teamId = teamId;
        this.memberId = memberId;
    }
}
