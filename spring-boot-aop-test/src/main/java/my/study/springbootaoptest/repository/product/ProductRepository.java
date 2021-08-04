package my.study.springbootaoptest.repository.product;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    public String getName() {
        System.out.println("ProductRepository.getName()");
        return "macbook";
    }

    public void error() {
        throw new IllegalStateException("productRepository error");
    }
}
