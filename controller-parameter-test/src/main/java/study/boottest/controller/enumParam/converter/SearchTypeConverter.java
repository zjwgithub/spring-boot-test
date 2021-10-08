package study.boottest.controller.enumParam.converter;

import org.springframework.core.convert.converter.Converter;
import study.boottest.controller.enumParam.type.SearchType;

public class SearchTypeConverter implements Converter<String, SearchType> {
    
    @Override
    public SearchType convert(String source) {
        SearchType searchType = SearchType.of(source);
        return searchType;
    }
}
