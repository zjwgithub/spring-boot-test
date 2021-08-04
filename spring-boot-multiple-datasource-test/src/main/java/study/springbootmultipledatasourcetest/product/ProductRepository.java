package study.springbootmultipledatasourcetest.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT version()", nativeQuery = true)
    String version();

}
