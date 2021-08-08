package test;

import framework.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import standard.BoardImpl;
import standard.Solver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolverTest {
    private Board board2Solved;
    private Board board2;
    private Solver solver;



    @BeforeEach
    void setUp() {
        board2 = new BoardImpl("C:\\Users\\Magnus\\IdeaProjects\\SudokuSolver\\src\\sudoku\\Sudoku2.txt");
        board2Solved = new BoardImpl("C:\\Users\\Magnus\\IdeaProjects\\SudokuSolver\\src\\sudoku\\Sudoku2Solved.txt");
        solver = new Solver();
    }


    @Test
    void sudoku2IsCorrectlySolved(){
        solver.solve(board2);
        assertEquals(board2Solved,board2);
    }

}