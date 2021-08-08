package standard;

import framework.Board;

import java.util.ArrayList;
import java.util.Collections;

public class BoardGenerator {
    private MoveVerifier verifier;

    public BoardGenerator(){
        verifier = new MoveVerifier();
    }

    public Board generateRandomBoard(){
        return new BoardImpl("C:\\Users\\Magnus\\IdeaProjects\\SudokuSolver\\src\\sudoku\\Sudoku1.txt");
    }

    public Board generateCompleteRandomBoard(){
        Board board = getZeroBoard();
        generateCompleteRandomBoardRecursive(board,new Position(0,0));
        return board;
    }

    public boolean generateCompleteRandomBoardRecursive(Board board, Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        if (column == 9) {
            if (row == 8){
                return true;
            }
            row += 1;
            column = 0;
        }

        Solver solver = new Solver();
        ArrayList<Integer> allowedList = getMoveList19();
        Collections.shuffle(allowedList);

        for (int num : allowedList) {
            if (verifier.isAllowedMove(board,new Position(row, column),num)){
                board.setInteger(new Position(row, column), num);
                if (generateCompleteRandomBoardRecursive(board, new Position(row, column + 1))){
                    return true;
                }
            }
            board.setInteger(new Position(row, column), 0);
        }
        return false;
    }

    private Board getZeroBoard() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 81; i++){
            list.add(0);
        }
        return new BoardImpl(list);
    }

    public ArrayList<Integer> getMoveList19(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int num = 1; num <= 9; num++){
            list.add(num);
        }
        return list;
    }

}
