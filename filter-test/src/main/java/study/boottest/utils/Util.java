package study.boottest.utils;

public class Util {

    public static void print(Class clazz, Object obj) {
        System.out.println();
        System.out.println("## " + clazz.getSimpleName() + " | " + obj);
        System.out.println();
    }
}
