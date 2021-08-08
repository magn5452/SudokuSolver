package standard;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public final class SudokuReader {
    private static final SudokuReader INSTANCE = new SudokuReader();

    public static SudokuReader getInstance() {
        return INSTANCE;
    }
    public SudokuReader(){}

    public static ArrayList<Integer> readFile(String pathName) {
        try {
            File file = new File(pathName);
            Scanner scanner = new Scanner(file);
            ArrayList<Integer> list = new ArrayList<>() ;
            int integer;
            while(scanner.hasNextInt()) {
                integer = scanner.nextInt();
                list.add(integer);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
