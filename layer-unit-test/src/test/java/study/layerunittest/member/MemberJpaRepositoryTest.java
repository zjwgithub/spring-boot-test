package study.layerunittest.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    void notNull() {
        assertThat(memberJpaRepository).isNotNull();
    }

    @Test
    void save() {
        Member memberA = new Member("memberA", 10);
        
        Member saveMember = memberJpaRepository.save(memberA);

        Member findMember = memberJpaRepository.findById(memberA.getId());

        assertThat(findMember).isEqualTo(memberA);
    }

    @Test
    void findByName() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}