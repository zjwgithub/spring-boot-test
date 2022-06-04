package study.importimportresourcetest.importTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.importimportresourcetest.service.ItemService;
import study.importimportresourcetest.service.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ImportTest {

    @Autowired
    MemberService memberService;

    @Autowired
    ItemService itemService;

    @Test
    void name() {
        assertThat(memberService.hello()).isEqualTo("hello member");
        assertThat(itemService.hello()).isEqualTo("hello item");
    }
}
