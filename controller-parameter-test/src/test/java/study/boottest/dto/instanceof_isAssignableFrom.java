package study.boottest.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class instanceof_isAssignableFrom {

    @Test
    void instanceof_test() {
        Board board = new Board();
        NewsBoard newsBoard = new NewsBoard();
        
        assertThat(board instanceof Board).isTrue(); // true
        assertThat(board instanceof NewsBoard).isFalse(); // false
    
        assertThat(newsBoard instanceof Board).isTrue(); // true
        assertThat(newsBoard instanceof NewsBoard).isTrue(); // true
    }
    
    @Test
    void isAssignableFrom_test() {
        Board board = new Board();
        NewsBoard newsBoard = new NewsBoard();
        
        assertThat(Board.class.isAssignableFrom(board.getClass())).isTrue(); // true
        assertThat(NewsBoard.class.isAssignableFrom(board.getClass())).isFalse(); // false
    
        assertThat(Board.class.isAssignableFrom(newsBoard.getClass())).isTrue(); // true
        assertThat(NewsBoard.class.isAssignableFrom(newsBoard.getClass())).isTrue(); // true
    }
}
