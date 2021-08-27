package study.boottest.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepository {
    
    private static long sequence = 0L;
    private static Map<Long, Member> store = new HashMap<>();

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }
    
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    
    public Optional<Member> findByLoginId(String loginId) {
        return store.values().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }
}
