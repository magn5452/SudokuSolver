package standard;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public final class FileReader {
    private static final FileReader INSTANCE = new FileReader();

    public static FileReader getInstance() {
        return INSTANCE;
    }
    public FileReader(){}

    public static ArrayList<Integer> readFile(String pathName) {
        try {
            File file = new File(pathName);
            Scanner scanner = new Scanner(file);
            ArrayList<Integer> list = new ArrayList<>() ;
            int integer = 0;
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
