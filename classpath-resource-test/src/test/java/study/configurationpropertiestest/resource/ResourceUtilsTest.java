package study.configurationpropertiestest.resource;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class ResourceUtilsTest {

    @Test
    void file1Test() throws IOException {
        File file = ResourceUtils.getFile("classpath:file1.txt");

        testAsFile(file, "1번 파일입니다");
    }

    @Test
    void file2Test() throws IOException {
        File file = ResourceUtils.getFile("classpath:aa/bb/file2.txt");

        testAsFile(file, "2번 파일입니다");
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
