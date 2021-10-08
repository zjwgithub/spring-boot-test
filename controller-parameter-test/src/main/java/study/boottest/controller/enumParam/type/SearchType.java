package study.boottest.controller.enumParam.type;

public enum SearchType {
    
    TITLE,
    CONTENT,
    ;

    public static SearchType of(String searchType) {
        if (searchType.toUpperCase().equals(SearchType.TITLE.name())) {
            return SearchType.TITLE;
        }
        if (searchType.toUpperCase().equals(SearchType.CONTENT.name())) {
            return SearchType.CONTENT;
        }
        return null;
    }
}
