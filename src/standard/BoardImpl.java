package standard;

import framework.Board;

import java.util.ArrayList;
import java.util.Map;


public class BoardImpl implements Board {
    private Map<Position, Integer> boardIntegerMap;

    public BoardImpl() {
        FileReader reader = new FileReader();
        ArrayList<Integer> list = reader.readFile("C:\\Users\\Magnus\\IdeaProjects\\SudokuSolver\\src\\Sudoku1.txt");
        BoardMapConstructor boardMapConstructor = new BoardMapConstructor();
        this.boardIntegerMap = boardMapConstructor.setUpIntegerMap(list);
    }

    public BoardImpl(ArrayList<Integer> list) {
        BoardMapConstructor boardMapConstructor = new BoardMapConstructor();
        this.boardIntegerMap = boardMapConstructor.setUpIntegerMap(list);
    }

    public Map<Position, Integer> getBoardIntegerMap() {
        return boardIntegerMap;
    }

    @Override
    public int getInteger(Position position) {
        return boardIntegerMap.get(position);
    }

    @Override
    public void setInteger(Position position, int num) {
        boardIntegerMap.put(position,num);
    }

    public ArrayList<Integer> getRow(int index) {
        ArrayList<Integer> rowList = new ArrayList<>();
        for(int i = 0; i < 9; i++){
                Position position = new Position(index,i);
                int integer = boardIntegerMap.get(position);
                rowList.add(integer);
        }
        return rowList;
    }

    public ArrayList<Integer> getColumn(int index) {
        ArrayList<Integer> columnList = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            Position position = new Position(i,index);
            int integer = boardIntegerMap.get(position);
            columnList.add(integer);
        }
        return columnList;
    }

    @Override
    public void print(){
        System.out.println("___________________________");
        for (int i = 0; i < 9; i++){
            System.out.println(getRow(i));
        }
    }

    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o.getClass() != BoardImpl.class) { return false; }
        BoardImpl other = (BoardImpl) o;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Position position = new Position(i,j);
                if (other.getInteger(position) != getInteger(position)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        int hash = 23 ;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Position position = new Position(i,j);
                hash = hash * 31 + i;
                hash = hash * 31 + j;
                hash = hash * 31 + getInteger(position);
            }
        }
        return hash;
    }

}
