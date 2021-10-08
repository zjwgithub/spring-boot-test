package study.boottest.controller.enumParam.type;

public enum SearchTypeCode {
    
    TITLE("10"),
    CONTENT("20"),
    ;

    private String code;

    SearchTypeCode(String code) {
        this.code = code;
    }

    public static SearchTypeCode of(String code) {
        if (code.equals("10")) return SearchTypeCode.TITLE;
        if (code.equals("20")) return SearchTypeCode.CONTENT;
        return null;
    }
}
