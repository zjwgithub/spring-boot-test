package study.springboottestannotationtest.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class ServiceTestV1 {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void test() {
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        assertThat(memberService).isNotNull();

        ItemService itemService = applicationContext.getBean("itemService", ItemService.class);
        assertThat(itemService).isNotNull();

        applicationContextInfo();
    }

    private void applicationContextInfo() {
        int beanCount = applicationContext.getBeanDefinitionCount();
        log.info("beanCount={}", beanCount);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanNames)
                .forEach(beanName -> {
                    log.info("beanName={} bean={}", beanName, applicationContext.getBean(beanName).getClass());
                });
    }
}
