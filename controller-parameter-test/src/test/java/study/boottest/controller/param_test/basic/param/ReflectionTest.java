package study.boottest.controller.param_test.basic.param;

import org.junit.jupiter.api.Test;
import study.boottest.utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;

class ReflectionTest {

    @Test
    void name() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "james");
        map.put("age", 20);
        map.put("score", 100);
        System.out.println("map = " + map);

        MyDto myDto = new MyDto();
        System.out.println("myDto = " + myDto);

        ReflectionUtil.fillDtoFromMap(myDto, map);

        System.out.println("myDto = " + myDto);
    }

}
