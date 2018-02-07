package Utils;

import java.io.File;

public class Constants {
    public enum Status {
        PENDING,
        COMPLETE,
        ERROR
    }

    public static final String UPLOAD_DIR = "output/uploads";

    public static File uploadDir = new File(Constants.UPLOAD_DIR);
}
