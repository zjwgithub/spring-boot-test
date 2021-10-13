package study.boottest.dto;

import org.junit.jupiter.api.Test;

public class EnumInModelTest {

    @Test
    void name() {
        BoardDto boardDto = new BoardDto("제목", "내용", 20);
        BoardType boardType = boardDto.getBoardType();
        System.out.println("boardType = " + boardType);
    }
    
    static class BoardDto {
        
        private String title;
        private String content;
        private Integer boardTypeCode;
        private BoardType boardType;

        public BoardDto(String title, String content, Integer boardTypeCode) {
            this.title = title;
            this.content = content;
            this.boardTypeCode = boardTypeCode;
        }

        public BoardType getBoardType() {
            return BoardType.of(boardTypeCode);
        }
    }
    
    static enum BoardType {
        
        NEWS(10),
        MOVIE(20);
        
        private int code;

        BoardType(int code) {
            this.code = code;
        }
        
        public static BoardType of(int code) {
            if (code == 10) return NEWS;
            return MOVIE;
        }
    }
}
