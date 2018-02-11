package Utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static void copyFromResource(File file) {
        String pathToRes = "spdata.jpg";
        try (InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(pathToRes);
             OutputStream outputStream = new FileOutputStream(file)
        ) {
            IOUtils.copy(inputStream, outputStream);
            logger.debug("Resource {} copied to {}", pathToRes, file.getAbsolutePath());
        } catch (Exception err) {
            logger.error(err.getMessage());
        }
    }
}
