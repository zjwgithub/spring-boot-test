package study.layerunittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.layerunittest.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberExtRepository {
}
