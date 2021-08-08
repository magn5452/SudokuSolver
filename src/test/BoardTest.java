package test;

import framework.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import standard.BoardImpl;
import standard.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new BoardImpl();
    }

    @Test
    void shouldBe5AtPosition00() {
        Position position00 = new Position(0,0);
        assertEquals(board.getInteger(position00),5);
    }

    @Test
    void shouldBe0AtPosition33() {
        Position position33= new Position(3,3);
        assertEquals(board.getInteger(position33),0);
    }

    @Test
    void shouldBe6AtPosition61() {
        Position position61= new Position(6,1);
        assertEquals(board.getInteger(position61),6);
    }
}