package study.springdatajpaauditing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.springdatajpaauditing.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
