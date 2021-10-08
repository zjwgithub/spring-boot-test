package study.boottest.controller.enumParam.converter;

import org.springframework.core.convert.converter.Converter;
import study.boottest.controller.enumParam.type.SearchTypeCode;

public class SearchTypeCodeConverter implements Converter<String, SearchTypeCode> {
    
    @Override
    public SearchTypeCode convert(String source) {
        SearchTypeCode searchTypeCode = SearchTypeCode.of(source);
        return searchTypeCode;
    }
}
