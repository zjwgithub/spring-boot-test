package study.beannametest.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
@Component
public class MyApplicationRunner implements ApplicationRunner {

    private final ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println();

        log.info("MyApplicationRunner.run");
        log.info("applicationContext={}", applicationContext);

        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(beanName -> {
                    String packageName = applicationContext.getBean(beanName).getClass().getPackageName();
                    if (!packageName.startsWith("study.beannametest.app")) {
                        return;
                    }
                    log.info("  beanName={} bean={}", beanName, applicationContext.getBean(beanName).getClass());
                });
    }
}
