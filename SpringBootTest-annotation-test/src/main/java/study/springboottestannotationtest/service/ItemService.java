package study.springboottestannotationtest.service;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

    public String hello() {
        return "hello item";
    }
}
