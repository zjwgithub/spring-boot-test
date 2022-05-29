package study.staticfileaccess;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class AppInit implements CommandLineRunner {

    private final ResourceLoader resourceLoader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("~~~~~~~~~~~~~~~~ MyRunner.run");

        String filePath = "classpath:static/my-static-file.txt";
        Resource resource = resourceLoader.getResource(filePath);
        InputStream inputStream = resource.getInputStream();
        String str = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("str = " + str);
    }
}
