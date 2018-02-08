package Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DataFinder {

    private static final Logger logger = LoggerFactory.getLogger(DataFinder.class);

    public static List<String> findAllVerses(String fileName) {
        List<String> temp = new ArrayList<>();
        try {
            File dir = new File(Constants.VERSES_DIR);
            File[] foundFiles = dir.listFiles((dir1, name) ->
                    name.startsWith(fileName.substring(0, fileName.lastIndexOf("."))));
            assert foundFiles != null;
            sortByNumber(foundFiles);
            for (File file : foundFiles) {
                temp.add(file.getName());
            }
        } catch (Exception error) {
            logger.error(error.getMessage());
        }
        return temp;
    }

    public static List<String> findAllOverlap(String fileName) {
        List<String> temp = new ArrayList<>();
        try {
            File dir = new File(Constants.OVERLAP_DIR);
            File[] foundFiles = dir.listFiles((dir1, name) ->
                    name.contains(fileName.substring(0, fileName.lastIndexOf("."))));
            assert foundFiles != null;
            sortByNumber(foundFiles);
            for (File file : foundFiles) {
                temp.add(file.getName());
            }
        } catch (Exception error) {
            logger.error(error.getMessage());
        }
        return temp;
    }


    // Utils function to sort files
    private static void sortByNumber(File[] files) {
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int n1 = extractNumber(o1.getName());
                int n2 = extractNumber(o2.getName());
                return n1 - n2;
            }

            private int extractNumber(String name) {
                int i;
                try {
                    int s = name.lastIndexOf('_') + 1;
                    int e = name.lastIndexOf('.');
                    String number = name.substring(s, e);
                    i = Integer.parseInt(number);
                } catch (Exception e) {
                    i = 0; // if filename does not match the format
                    // then default to 0
                }
                return i;
            }
        });
    }
}
