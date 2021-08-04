package study.springbootcompositeprimarykey.idclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class TeamMemberId implements Serializable {

    private Long teamId;
    private Long memberId;

    public TeamMemberId(Long teamId, Long memberId) {
        this.teamId = teamId;
        this.memberId = memberId;
    }
}
