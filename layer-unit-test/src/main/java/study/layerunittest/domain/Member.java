package study.layerunittest.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode
public class Member {
    
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;
    
    @Column(name = "member_name")
    private String name;

    private Integer age;

    public Member(String loginId, String password, String name, Integer age) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeMemberInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
