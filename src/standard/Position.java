package standard;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o.getClass() != Position.class) { return false; }
        Position other = (Position) o;
        return row ==other.row  && column==other.column;
    }

    public int hashCode() {
        return 9*(row+1)+(column+1);
    }


    public String toString(){
        return "(" + row + "," + column + ")";
    }

    public void iterateRow(){
        this.row += 1;
    }

    public void iterateColumn(){
        this.column += 1;
    }
}
