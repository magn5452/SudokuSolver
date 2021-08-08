package standard;

import framework.Board;

public class MoveVerifier {

    public MoveVerifier(){}

    public boolean isAllowedMove(Board board, Position position, int integer) {
        int column = position.getColumn();
        int row = position.getRow();

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
}
