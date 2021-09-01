package study.layerunittest.member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class Member {
    
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    
    @Column(name = "member_name")
    private String name;
    private Integer age;

    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
