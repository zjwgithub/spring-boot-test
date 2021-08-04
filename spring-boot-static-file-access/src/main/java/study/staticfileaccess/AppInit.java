package study.staticfileaccess;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
public class AppInit implements CommandLineRunner {

    private final ResourceLoader resourceLoader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("~~~~~~~~~~~~~~~~ MyRunner.run");

        String filePath = "classpath:static/my-static-file.txt";
        InputStream inputStream = resourceLoader.getResource(filePath).getInputStream();
        String str = FileCopyUtils.copyToString(new InputStreamReader(inputStream));
        System.out.println("str = " + str);
    }
}
