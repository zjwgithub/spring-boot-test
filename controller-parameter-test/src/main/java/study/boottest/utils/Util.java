package study.boottest.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

public class Util {

    public static void print(Class clazz, Object obj) {
        System.out.println();
        System.out.println("## " + clazz.getSimpleName() + " | " + obj);
        System.out.println();
    }

    public static void printBindingResult(BindingResult bindingResult) {
        System.out.println();
        System.out.println("bindingResult.getErrorCount() = " + bindingResult.getErrorCount());
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError allError : allErrors) {
            System.out.println("  - allError = " + allError);
        }

        System.out.println("bindingResult.getGlobalErrorCount() = " + bindingResult.getGlobalErrorCount());
        List<ObjectError> globalErrors = bindingResult.getGlobalErrors();
        for (ObjectError globalError : globalErrors) {
            System.out.println("  - globalError = " + globalError);
        }

        System.out.println("bindingResult.getFieldErrorCount() = " + bindingResult.getFieldErrorCount());
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            System.out.println("  - fieldError = " + fieldError);
        }
        System.out.println();
    }
}
