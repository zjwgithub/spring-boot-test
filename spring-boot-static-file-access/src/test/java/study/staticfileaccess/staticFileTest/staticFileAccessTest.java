package study.staticfileaccess.staticFileTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class staticFileAccessTest {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void test1() throws IOException {
        String filePath = "classpath:static/my-static-file.txt";
        Resource resource = resourceLoader.getResource(filePath);
        InputStream inputStream = resource.getInputStream();
        String str = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("str = " + str);
        assertThat(str).isEqualTo("static 파일 입니다");
    }

    @Test
    void test2() throws IOException {
        String filePath = "classpath:static/my-static-file.txt";
        Resource resource = resourceLoader.getResource(filePath);
        InputStream inputStream = resource.getInputStream();
        String str = FileCopyUtils.copyToString(new InputStreamReader(inputStream));
        System.out.println("str = " + str);
        assertThat(str).isEqualTo("static 파일 입니다");
    }
}
