package study.springdatajpaauditing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.springdatajpaauditing.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
