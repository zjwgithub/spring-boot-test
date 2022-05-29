package study.beanpostprocessortest.initRun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        log.info("## CommandLineRunnerImpl.run");
        log.info("args={}", args);

        printAllBeans();
    }

    private void printAllBeans() {
        System.out.println();
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(beanName -> {
                    log.info("beanName={} bean={}", beanName, applicationContext.getBean(beanName).getClass());
                });
    }
}
