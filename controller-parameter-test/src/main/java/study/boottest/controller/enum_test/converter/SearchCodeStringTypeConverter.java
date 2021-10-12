package study.boottest.controller.enum_test.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import study.boottest.controller.enum_test.enumType.SearchCodeStringType;

@Slf4j
public class SearchCodeStringTypeConverter implements Converter<String, SearchCodeStringType> {
    
    @Override
    public SearchCodeStringType convert(String source) {
        log.info("convert source = " + source);
        SearchCodeStringType searchCodeStringType = SearchCodeStringType.of(source);
        return searchCodeStringType;
    }
}
