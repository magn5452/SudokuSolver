package standard;

import framework.Board;

public class Solver {

    private Board originalBoard;
    private MoveVerifier verifier;

    public Solver() {
        verifier  = new MoveVerifier();
    }

    public Board solve(Board originalBoard) {
        this.originalBoard = originalBoard;
        solveIterative(originalBoard,new Position(0,0));
        return originalBoard;
    }

    public boolean solveIterative(Board board,Position position){
        int row = position.getRow();
        int column = position.getColumn();

        if (column == 9) {
            if (row == 8){
                return true;
            }
            row += 1;
            column = 0;
        }

        if (board.getInteger(new Position(row, column)) != 0) {
            return solveIterative(board, new Position(row, column + 1));
        }

        for (int num = 1; num <= 9; num++){
            if (verifier.isAllowedMove(board,new Position(row, column), num)){
                board.setInteger(new Position(row, column), num);
                if (solveIterative(board, new Position(row, column + 1))){
                    return true;
                }
            }
            board.setInteger(new Position(row, column), 0);
        }
        return false;
    }



}
