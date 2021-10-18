package study.refactoringtest.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    
    @Column(length = 50, nullable = false)
    private String username;
    
    @Column(length = 3)
    private Integer age;

    public Member(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public Member(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
