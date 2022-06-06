package study.configurationpropertiestest.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ValueAnnotationTest {

    @Value("classpath:file1.txt")
    Resource resourceFile1;

    @Value("classpath:aa/bb/file2.txt")
    Resource resourceFile2;

    @Test
    void file1Test() throws IOException {
        testAsInputStream(resourceFile1.getInputStream(), "1번 파일입니다");
        testAsFile(resourceFile1.getFile(), "1번 파일입니다");
    }

    @Test
    void file2Test() throws IOException {
        testAsInputStream(resourceFile2.getInputStream(), "2번 파일입니다");
        testAsFile(resourceFile2.getFile(), "2번 파일입니다");
    }

    private void testAsInputStream(InputStream inputStream, String expected) throws IOException {
        String content = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        assertThat(content).isEqualTo(expected);
    }

    private void testAsFile(File file, String expected) throws IOException {
        byte[] bytes = Files.readAllBytes(file.toPath());
        String content = new String(bytes, StandardCharsets.UTF_8);
        assertThat(content).isEqualTo(expected);
    }
}
