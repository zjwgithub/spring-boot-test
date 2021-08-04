package study.springbootmultipledatasourcetest.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select banner from v$version", nativeQuery = true)
    String version();

}
