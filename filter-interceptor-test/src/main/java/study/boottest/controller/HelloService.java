package study.boottest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static study.boottest.utils.Util.print;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public void hello() {
        print(getClass(), "시작");
        helloRepository.hello();
        print(getClass(), "종료");
    }
}
