package standard;

import java.util.ArrayList;

public class main {
    public static void main(String[] args){

        ArrayList<Integer> list = FileReader.readFile("C:\\Users\\Magnus\\IdeaProjects\\SudokuSolver\\src\\Sudoku2.txt");

        BoardImpl board = new BoardImpl(list);
        board.print();
        System.out.println(board.hashCode());

        Solver solver = new Solver(board);
        solver.solve();
        solver.getOriginalBoard().print();
        System.out.println(solver.getOriginalBoard().hashCode());

    }
}
