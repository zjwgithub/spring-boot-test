package study.layerunittest.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

//@Repository
@RequiredArgsConstructor
public class MemberExtRepositoryImpl implements MemberExtRepository {
    
    private final EntityManager em;
    
    @Override
    public int increaseAge(int addAge) {
        return em.createQuery("update Member m set m.age = m.age  + :age")
                .setParameter("age", addAge)
                .executeUpdate();
    }
}
