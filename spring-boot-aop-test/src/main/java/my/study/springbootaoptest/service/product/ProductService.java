package my.study.springbootaoptest.service.product;

import lombok.RequiredArgsConstructor;
import my.study.springbootaoptest.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String getName() {
        System.out.println("ProductService.getName()");
        return productRepository.getName();
    }

    public void error() {
        productRepository.error();
    }
}
