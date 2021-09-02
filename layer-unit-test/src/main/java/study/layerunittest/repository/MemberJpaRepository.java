package study.layerunittest.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.layerunittest.domain.Member;

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
    
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name")
                .setParameter("name", name)
                .getResultList();
    }

    public int deleteById(Long id) {
        return em.createQuery("delete from Member m where m.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
    
    public int deleteAll() {
        return em.createQuery("delete from Member m")
                .executeUpdate();
    }

    public int increaseAge(int addAge) {
        return em.createQuery("update Member m set m.age = m.age  + :age")
                .setParameter("age", addAge)
                .executeUpdate();
    }
    
}
