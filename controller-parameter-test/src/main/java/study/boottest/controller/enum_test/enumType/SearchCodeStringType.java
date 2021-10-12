package study.boottest.controller.enum_test.enumType;

public enum SearchCodeStringType {
    
    TITLE("10"),
    CONTENT("20"),
    ;

    private String code;

    SearchCodeStringType(String code) {
        this.code = code;
    }

    public static SearchCodeStringType of(String code) {
        if (code.equals("10")) return TITLE;
        if (code.equals("20")) return CONTENT;
        return null;
    }
}
