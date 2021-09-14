package study.jpaauditing.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberJpaRepository {
    
    private final EntityManager em;

    public Member save(Member member) {
        em.persist(member);
        return member;
    }
    
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    
    public void deleteAll() {
        em.createQuery("delete from Member m")
                .executeUpdate();
    }

    public void deleteById(Long id) {
        Member member = em.find(Member.class, id);
        em.remove(member);
    }
}
