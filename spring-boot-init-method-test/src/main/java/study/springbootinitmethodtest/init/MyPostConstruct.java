package study.springbootinitmethodtest.init;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyPostConstruct {

    @PostConstruct
    public void run() {
        System.out.println();
        System.out.println("MyPostConstruct");
        System.out.println();
    }
}
