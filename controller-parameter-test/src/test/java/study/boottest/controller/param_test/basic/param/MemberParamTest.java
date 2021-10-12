package study.boottest.controller.param_test.basic.param;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MemberParamTest {

    @Test
    void name() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "james");
        map.put("age", 20);
        map.put("score", 100);

        MyDto myDto = new MyDto();
        Class<? extends MyDto> clazz1 = myDto.getClass();
        Class<MemberParam> clazz2 = MemberParam.class;

        System.out.println();
        System.out.println("## getFields()");
        Arrays.asList(clazz1.getFields()).stream()
                .forEach(field -> {
                    System.out.println();
                    System.out.println("field = " + field);
                });

        System.out.println();
        System.out.println("## getDeclaredFields()");
        Arrays.asList(clazz1.getDeclaredFields()).stream()
                .forEach(field -> {
                    System.out.println();
                    System.out.println("field = " + field);
                    int modifiers = field.getModifiers();
                    if (modifiers == Modifier.PUBLIC) System.out.println("modifiers = PUBLIC");
                    if (modifiers == Modifier.PROTECTED) System.out.println("modifiers = PROTECTED");
                    if (modifiers == Modifier.PRIVATE) System.out.println("modifiers = PRIVATE");
                    Class<?> type = field.getType();
                    System.out.println("type = " + type);
                    String name = field.getName();
                    System.out.println("name = " + name);
                    Object mapValue = map.get(name);
                    System.out.println("mapValue = " + mapValue);
                    if (type.isAssignableFrom(Integer.class)) {
                    }
                });
    }
}