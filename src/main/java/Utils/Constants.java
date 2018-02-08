package Utils;

import java.io.File;

public class Constants {
    public enum Status {
        PENDING,
        COMPLETE,
        ERROR
    }

    public static final String VERSES_DIR = "output/tashih/processed/verse";
    public static final String OVERLAP_DIR = "output/tashih/processed/line/actual";
    public static final String UPLOAD_DIR = "output/uploads";

    public static File uploadDir = new File(Constants.UPLOAD_DIR);
}
