package study.boottest.controller.enum_test.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import study.boottest.controller.enum_test.enumType.SearchType;

@Slf4j
public class SearchTypeConverter implements Converter<String, SearchType> {
    
    @Override
    public SearchType convert(String source) {
        log.info("convert source = " + source);
        SearchType searchType = SearchType.of(source);
        return searchType;
    }
}
