package study.boottest.controller.converter_test.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IntegerToStringConverter implements Converter<Integer, String> {
    
    @Override
    public String convert(Integer source) {
        log.info("convert source = {}", source);
        String string = String.valueOf(source);
        return string;
    }
}
