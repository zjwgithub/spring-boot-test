package study.boottest.controller.enum_test.enumType;

public enum SearchType {
    
    TITLE,
    CONTENT,
    ;

    public static SearchType of(String searchType) {
        if (searchType.toUpperCase().equals(TITLE.name())) {
            return TITLE;
        }
        if (searchType.toUpperCase().equals(CONTENT.name())) {
            return CONTENT;
        }
        return null;
    }
}
