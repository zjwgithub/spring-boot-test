package study.layerunittest.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

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
    
    public Member findById(Long id) {
        return em.find(Member.class, id);
//        return em.createQuery("select m from Member m where m.id = :id", Member.class)
//                .setParameter("id", id)
//                .getSingleResult();
    }
    
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name")
                .setParameter("name", name)
                .getResultList();
    }

    public int update(Long id, Member member) {
        return em.createQuery("update Member m set m.name = :name, m.age = :age where m.id = :id")
                .setParameter("id", id)
                .setParameter("name", member.getName())
                .setParameter("age", member.getAge())
                .executeUpdate();
    }

    public int deleteById(Long id) {
        return em.createQuery("delete from Member m where m.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
