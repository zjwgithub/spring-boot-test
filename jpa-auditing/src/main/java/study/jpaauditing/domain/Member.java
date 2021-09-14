package study.jpaauditing.domain;

import lombok.*;
import study.jpaauditing.domain.base.JpaBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends JpaBaseEntity {
    
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    
    private String name;
    private Integer age;

    public Member(String name) {
        this.name = name;
    }
}
