package study.springbootmultipledatasourcetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import study.springbootmultipledatasourcetest.member.Member;
import study.springbootmultipledatasourcetest.member.MemberRepository;
import study.springbootmultipledatasourcetest.product.Product;
import study.springbootmultipledatasourcetest.product.ProductRepository;

import java.util.List;

@Component
public class AppInit implements CommandLineRunner {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        System.out.println("--AppInit");

        version();
        memberTest();
        productTest();
    }

    private void version() {
        System.out.println("memberRepository.version()  = " + memberRepository.version());
        System.out.println("productRepository.version() = " + productRepository.version());
    }

    private void memberTest() {
        memberRepository.save(new Member("member11", 11));
        memberRepository.save(new Member("member22", 22));
        memberRepository.save(new Member("member33", 33));
        List<Member> findList = memberRepository.findAll();
        Assert.isTrue(findList.size() == 3, "findList size must be 3");
    }

    private void productTest() {
        productRepository.save(new Product("product11", "factory11"));
        productRepository.save(new Product("product22", "factory22"));
        productRepository.save(new Product("product33", "factory33"));
        List<Product> findList = productRepository.findAll();
        Assert.isTrue(findList.size() == 3, "findList size must be 3");
    }
}
