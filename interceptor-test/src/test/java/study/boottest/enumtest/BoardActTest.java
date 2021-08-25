package study.boottest.enumtest;

import org.junit.jupiter.api.Test;

class BoardActTest {

    @Test
    void name() {
        BoardAct like = BoardAct.LIKE;
        BoardAct dislike = BoardAct.DISLIKE;
        BoardAct accuse = BoardAct.ACCUSE;

        print(like);
        print(dislike);
        print(accuse);

        BoardAct bc = BoardAct.valueOf("LIKE");
        print(bc);
    }

    private void print(BoardAct boardAct) {
        System.out.println();
        System.out.println("boardAct              = " + boardAct);
        System.out.println("boardAct.name()       = " + boardAct.name());
        System.out.println("boardAct.toString()   = " + boardAct.toString());
        System.out.println("boardAct.getCodeNum() = " + boardAct.getCodeNum());
        System.out.println("boardAct.ordinal() = " + boardAct.ordinal());
    }
}
