package study.boottest.controller;

import org.springframework.stereotype.Repository;

import static study.boottest.utils.Util.print;

@Repository
public class HelloRepository {
    
    public void hello() {
        print(getClass(), "시작");
        print(getClass(), "종료");
    }
}
