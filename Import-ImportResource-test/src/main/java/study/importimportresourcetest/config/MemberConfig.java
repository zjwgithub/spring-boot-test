package study.importimportresourcetest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.importimportresourcetest.service.MemberService;

@Configuration
public class MemberConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService();
    }
}
