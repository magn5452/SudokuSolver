package standard;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardMapConstructor {
    public void boardMapFactory(){

    }

    public HashMap<Position,Integer> setUpIntegerMap(ArrayList<Integer> list){
        if (list.size() == 81) {
            HashMap<Position,Integer> map = new HashMap<>();
            Position position;
            int integer;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    position = new Position(i,j);
                    integer =  list.get(9*i+j);
                    map.put(position, integer);
                }
            }
            return map;
        }
        else {
            return null;
        }
    }



}
