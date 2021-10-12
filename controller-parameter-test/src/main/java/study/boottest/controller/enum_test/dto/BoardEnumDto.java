package study.boottest.controller.enum_test.dto;

import lombok.Data;
import study.boottest.controller.enum_test.enumType.GenreType;
import study.boottest.controller.enum_test.enumType.SearchCodeNumberType;
import study.boottest.controller.enum_test.enumType.SearchCodeStringType;

@Data
public class BoardEnumDto {
    
    private String title;
    private String content;
    private SearchCodeNumberType searchType;
//    private SearchCodeStringType searchType;
    private GenreType genreType; // 컨버터를 등록하지 않는 경우 기본적으로 대문자로 전송해야 함
}
