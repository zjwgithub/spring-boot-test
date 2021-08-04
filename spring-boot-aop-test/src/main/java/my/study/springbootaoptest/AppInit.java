package my.study.springbootaoptest;

import lombok.RequiredArgsConstructor;
import my.study.springbootaoptest.controller.member.MemberController;
import my.study.springbootaoptest.controller.product.ProductController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppInit {

    private final MemberController memberController;
    private final ProductController productController;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            memberController.getName("beautiful life", 123);
            productController.getName();
            try {
                memberController.error();
            } catch (Exception e) {

            }
            try {
                productController.error();
            } catch (Exception e) {

            }
        };
    }
}
