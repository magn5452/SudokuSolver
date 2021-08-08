package test;

import framework.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import standard.BoardImpl;
import standard.MoveVerifier;
import standard.Position;

import static org.junit.jupiter.api.Assertions.*;

class MoveVerifierTest {
    private Board board1;
    private MoveVerifier verifier;
    @BeforeEach
    void setUp() {
        verifier = new MoveVerifier();
        board1 = new BoardImpl("C:\\Users\\Magnus\\IdeaProjects\\SudokuSolver\\src\\sudoku\\Sudoku1.txt");
    }

    @Test
    void integer5At08IsNotAllowedBecauseOfRow() {
        Position position08 = new Position(0,8);
        assertFalse(verifier.isAllowedMove(board1,position08,5));
    }

    @Test
    void integer8At72IsNotAllowedBecauseOfColumn() {
        Position position72 = new Position(7,2);
        assertFalse(verifier.isAllowedMove(board1,position72,5));
    }

    @Test
    void integer3At53IsNotAllowedBecauseOfSquare() {
        Position position53 = new Position(5,3);
        assertFalse(verifier.isAllowedMove(board1,position53,3));
    }

    @Test
    void integer8At81IsNotAllowedBecauseOfSquare() {
        Position position81 = new Position(8,1);
        assertFalse(verifier.isAllowedMove(board1,position81,8));
    }
}