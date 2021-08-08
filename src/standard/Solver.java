package standard;

import framework.Board;

public class Solver<originalBoard> {

    private static Board originalBoard;

    public Solver(Board originalBoard) {
        this.originalBoard = originalBoard;
    }

    public void solve() {
        solveIterative(originalBoard,new Position(0,0));
    }

    public boolean solveIterative(Board board,Position position){
        int row = position.getRow();
        int column = position.getColumn();

        if (column == 9) {
            if (row == 8){
                originalBoard = board;
                return true;

            }
            row += 1;
            column = 0;
        }

        if (board.getInteger(new Position(row, column)) != 0) {
            return solveIterative(board, new Position(row, column + 1));
        }

        for (int num = 1; num <= 9; num++){
            if (isAllowedMove(board,new Position(row, column), num)){
                board.setInteger(new Position(row, column), num);
                if (solveIterative(board, new Position(row, column + 1))){
                    return true;
                }
            }
            board.setInteger(new Position(row, column), 0);
        }
        return false;
    }

    public boolean isAllowedMove(Board board, Position position, int integer) {
        int column = position.getColumn();
        int row = position.getRow();

        int originalInteger = originalBoard.getInteger(position);

        for (int i = 0; i < 9; i++){
            if (board.getInteger(new Position(row, i)) == integer) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++){
            if (board.getInteger(new Position(i, column)) == integer) {
                return false;
            }
        }

        int cornerRow = row - row % 3;
        int cornerColumn = column - column % 3;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                int integerAtPosition = board.getInteger(new Position(cornerRow + i, cornerColumn + j));
                if (integer == integerAtPosition) {
                    return false;
                }
            }
        }
        return true;
    }

    public Board getOriginalBoard() {
        return originalBoard;
    }

}
