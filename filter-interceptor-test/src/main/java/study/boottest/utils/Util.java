package study.boottest.utils;

public class Util {

    public static void print(Class clazz, Object obj) {
//        System.out.println();
        System.out.println(rpad("## " + clazz.getSimpleName(), 20, " ") + " | " + obj);
//        System.out.println();
    }

    public static String rpad(Object obj, int len, String padding) {
        String str = String.valueOf(obj);
        while (str.length() < len) {
            str = str + padding;
        }
        return str;
    }
}
