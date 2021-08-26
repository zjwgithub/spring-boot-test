package study.boottest.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@ToString
public class Member {
    
    private Long id;
    private String loginId;
    private String password;

    public Member(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
