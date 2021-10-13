package study.boottest.utils;

import org.springframework.web.context.request.NativeWebRequest;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReflectionUtil {
    
    public static void fillDtoFromMap(Object object, Map<String, Object> map) {
        try {
            List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(object, map.get(field.getName()));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("cannot fill dto", e);
        }
    }
    
    public static void fillDtoFromNativeWebRequest(Object object, NativeWebRequest nativeWebRequest) {
        List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldType = field.getType().getName();
            String fieldValue = nativeWebRequest.getParameter(fieldName);
            try {
                field.setAccessible(true);
                Class<?> type = field.getType();
                if (type.isAssignableFrom(boolean.class)) {
                    boolean value = Boolean.parseBoolean(fieldValue);
                    field.set(object, value);
                    continue;
                }
                if (type.isAssignableFrom(int.class)) {
                    int value = Integer.parseInt(fieldValue);
                    field.set(object, value);
                    continue;
                }
                if (type.isAssignableFrom(long.class)) {
                    long value = Long.parseLong(fieldValue);
                    field.set(object, value);
                    continue;
                }
                if (type.isAssignableFrom(Integer.class)) {
                    Integer value = Integer.valueOf(fieldValue);
                    field.set(object, value);
                    continue;
                }
                if (type.isAssignableFrom(Long.class)) {
                    Long value = Long.valueOf(fieldValue);
                    field.set(object, value);
                    continue;
                }
                field.set(object, fieldValue);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("cannot fill dto, fieldName=" + fieldName + ", fieldType=" + fieldType + ", fieldValue=" + fieldValue, e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("cannot fill dto, fieldName=" + fieldName + ", fieldType=" + fieldType + ", fieldValue=" + fieldValue, e);
            }
        }
    }
}
