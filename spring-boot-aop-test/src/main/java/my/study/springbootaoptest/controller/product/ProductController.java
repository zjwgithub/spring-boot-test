package my.study.springbootaoptest.controller.product;

import lombok.RequiredArgsConstructor;
import my.study.springbootaoptest.service.product.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    public void getName() {
        System.out.println("ProductController.getName()");
        String name = productService.getName();
        System.out.println("product name = " + name);
    }

    public void error() {
        productService.error();
    }
}
