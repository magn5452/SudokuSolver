package framework;

import standard.Position;

public interface Board {
    public int getInteger(Position position);
    public void setInteger(Position position, int num);
    public void print();
}
