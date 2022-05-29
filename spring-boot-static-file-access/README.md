## static file access test

```java
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

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
```
