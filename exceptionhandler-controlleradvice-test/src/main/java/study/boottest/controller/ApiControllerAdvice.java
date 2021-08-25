package study.boottest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static study.boottest.utils.Util.*;

@RestControllerAdvice(basePackages = "study.boottest.controller.api")
public class ApiControllerAdvice {

    @ExceptionHandler
    public void handleRuntimeException(RuntimeException ex) {
        print(getClass(), ex);
    }

    @ExceptionHandler
    public void handleException(Exception ex) {
        print(getClass(), ex);
    }
}
