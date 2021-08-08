package test;

import framework.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import standard.BoardImpl;
import standard.FileReader;
import standard.Position;
import standard.Solver;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {
    private Board board1;
    private Board board2Solved;
    private Board board2;
    Solver solver1;
    Solver solver2;


    @BeforeEach
    void setUp() {
        board1 = new BoardImpl();
        ArrayList<Integer> list2 = FileReader.readFile("C:\\Users\\Magnus\\IdeaProjects\\SudokuSolver\\src\\Sudoku2.txt");
        board2 = new BoardImpl(list2);
        ArrayList<Integer> list2Solved = FileReader.readFile("C:\\Users\\Magnus\\IdeaProjects\\SudokuSolver\\src\\Sudoku2Solved.txt");
        board2Solved = new BoardImpl(list2Solved);
        solver1 = new Solver(board1);
        solver2 = new Solver(board2);

    }

    @Test
    void integer5At08IsNotAllowedBecauseOfRow() {
        Position position08 = new Position(0,8);
        assertFalse(solver1.isAllowedMove(board1,position08,5));
    }

    @Test
    void integer8At72IsNotAllowedBecauseOfColumn() {
        Position position72 = new Position(7,2);
        assertFalse(solver1.isAllowedMove(board1,position72,5));
    }

    @Test
    void integer3At53IsNotAllowedBecauseOfSquare() {
        Position position53 = new Position(5,3);
        assertFalse(solver1.isAllowedMove(board1,position53,3));
    }

    @Test
    void integer8At81IsNotAllowedBecauseOfSquare() {
        Position position81 = new Position(8,1);
        assertFalse(solver1.isAllowedMove(board1,position81,8));
    }

    @Test
    void sudoku2IsCorrectlySolved(){
        solver2.solve();
        assertTrue(board2Solved.equals(solver2.getOriginalBoard()));
    }

}