# ClassPathResource 테스트

## `src/main/resources` 경로에 파일 생성
src/main/resources/file1.txt
```
1번 파일입니다
```
src/main/resources/aa/bb/file2.txt
```
2번 파일입니다
```

## 테스트
```java
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
```
file1Test 테스트 결과
```
path = file1.txt
filename = file1.txt
content = 1번 파일입니다
```
file2Test 테스트 결과
```
path = aa/bb/file2.txt
filename = file2.txt
content = 2번 파일입니다
```
