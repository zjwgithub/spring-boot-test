package study.boottest.controller.enum_test.enumType;

public enum SearchCodeNumberType {
    
    TITLE(10),
    CONTENT(20),
    ;

    private Integer code;

    SearchCodeNumberType(Integer code) {
        this.code = code;
    }

    public static SearchCodeNumberType of(String code) {
        if (code.equals("10")) return SearchCodeNumberType.TITLE;
        if (code.equals("20")) return SearchCodeNumberType.CONTENT;
        return null;
    }
}
