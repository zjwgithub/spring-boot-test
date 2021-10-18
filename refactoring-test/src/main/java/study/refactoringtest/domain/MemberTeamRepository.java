package study.refactoringtest.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTeamRepository extends JpaRepository<MemberTeam, MemberTeamId> {
}
