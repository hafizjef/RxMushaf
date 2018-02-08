package Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataFinder {
    public static List<String> findAllVerses(String fileName) {
        File dir = new File(Constants.VERSES_DIR);
        File[] foundFiles = dir.listFiles((dir1, name) -> name.startsWith(fileName.substring(0, fileName.lastIndexOf("."))));

        List<String> temp = new ArrayList<>();

        assert foundFiles != null;
        for (File file : foundFiles) {
            temp.add(file.getName());
        }

        return temp;
    }

    public static List<String> findAllOverlap(String fileName) {
        File dir = new File(Constants.OVERLAP_DIR);
        File[] foundFiles = dir.listFiles((dir1, name) -> name.contains(fileName.substring(0, fileName.lastIndexOf("."))));

        List<String> temp = new ArrayList<>();

        assert foundFiles != null;
        for (File file : foundFiles) {
            temp.add(file.getName());
        }
        return temp;
    }
}
