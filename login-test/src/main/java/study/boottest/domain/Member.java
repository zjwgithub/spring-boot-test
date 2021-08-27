package study.boottest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor
public class Member {
    
    @NotNull
    private Long id;
    
    @NotEmpty
    private String loginId;
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String password;

    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
}
