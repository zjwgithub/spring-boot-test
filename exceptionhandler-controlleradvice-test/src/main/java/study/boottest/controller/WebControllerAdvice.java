package study.boottest.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static study.boottest.utils.Util.*;

@ControllerAdvice(basePackages = "study.boottest.controller.web")
public class WebControllerAdvice {

    @ExceptionHandler
    public void handleRuntimeException(RuntimeException ex) {
        print(getClass(), ex);
    }

    @ExceptionHandler
    public void handleException(Exception ex) {
        print(getClass(), ex);
    }
}
