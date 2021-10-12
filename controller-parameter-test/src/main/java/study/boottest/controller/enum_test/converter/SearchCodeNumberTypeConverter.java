package study.boottest.controller.enum_test.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import study.boottest.controller.enum_test.enumType.SearchCodeNumberType;

@Slf4j
public class SearchCodeNumberTypeConverter implements Converter<String, SearchCodeNumberType> {
    
    @Override
    public SearchCodeNumberType convert(String source) {
        log.info("convert source = " + source);
        SearchCodeNumberType searchCodeNumberType = SearchCodeNumberType.of(source);
        return searchCodeNumberType;
    }
}
