package study.boottest.domain.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
@EqualsAndHashCode
@ToString
public class Member {
    
    private Long id;
    
    @NotBlank
    private String loginId;

    @NotBlank
    private String name;
    
    @NotNull
    private Integer age;

    @NotBlank
    private String password;

    public Member(String loginId, String name, Integer age, String password) {
        this.loginId = loginId;
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
