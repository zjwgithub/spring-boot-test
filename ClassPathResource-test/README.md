# classpath 에 있는 리소스 파일 읽기

1. Resource 사용
   - ClassPathResource
   - @Value
   - ResourceLoader
2. ResourceUtils 사용

리소스 파일
- src/main/resources/file1.txt
    ```
    1번 파일입니다
    ```
- src/main/resources/aa/bb/file2.txt
    ```
    2번 파일입니다
    ```

## ClassPathResource 사용

```java
public class ClassPathResourceTest {

    @Test
    void file1Test() throws IOException {
        ClassPathResource resource = new ClassPathResource("file1.txt");

        testAsInputStream(resource.getInputStream(), "1번 파일입니다");
        testAsFile(resource.getFile(), "1번 파일입니다");
    }

    @Test
    void file2Test() throws IOException {
        ClassPathResource resource = new ClassPathResource("aa/bb/file2.txt");

        testAsInputStream(resource.getInputStream(), "2번 파일입니다");
        testAsFile(resource.getFile(), "2번 파일입니다");
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
```

## @Value 사용

```java
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
```

## ResourceLoader 사용

```java
@SpringBootTest
public class ResourceLoaderTest {

    @Autowired
    ResourceLoader resourceLoader;

    @Test
    void file1Test() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:file1.txt");

        testAsInputStream(resource.getInputStream(), "1번 파일입니다");
        testAsFile(resource.getFile(), "1번 파일입니다");
    }

    @Test
    void file2Test() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:aa/bb/file2.txt");

        testAsInputStream(resource.getInputStream(), "2번 파일입니다");
        testAsFile(resource.getFile(), "2번 파일입니다");
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
```

## ResourceUtil 사용

```java
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
```
