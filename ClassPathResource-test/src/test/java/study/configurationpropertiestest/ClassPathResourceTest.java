package study.configurationpropertiestest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ClassPathResourceTest {

    @Test
    void file1Test() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("file1.txt");
        test(classPathResource);
    }

    @Test
    void file2Test() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("aa/bb/file2.txt");
        test(classPathResource);
    }

    void test(ClassPathResource classPathResource) throws IOException {
        String path = classPathResource.getPath();
        String filename = classPathResource.getFilename();
        String content = StreamUtils.copyToString(classPathResource.getInputStream(), StandardCharsets.UTF_8);
        System.out.println("path = " + path);
        System.out.println("filename = " + filename);
        System.out.println("content = " + content);
    }
}
