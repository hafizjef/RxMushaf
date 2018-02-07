package frontEnd.apiController;

import Utils.Constants;
import controller.ProcessImages;
import frontEnd.apiService.UserService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import model.ImageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static Utils.Constants.uploadDir;
import static Utils.JsonTransformer.json;
import static spark.Spark.post;

public class ProcessController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProcessController.class);

    public ProcessController(final UserService userService) {

        post("/api", (req, res) -> {
            // TODO:
            // Extract image & metadata from request payload
            // for further processing

            Path tempFile = Files.createTempFile(uploadDir.toPath(), "", ".jpg");
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

            try (InputStream inputStream = req.raw().getPart("image").getInputStream()) {
                Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception err) {
                res.status(500);
                logger.error(err.getMessage());
            }

            ImageModel img = new ImageModel(new File(Constants.UPLOAD_DIR + File.separator + tempFile.getFileName()), req.queryParams("email"));

            Observable.just(img)
                    .observeOn(Schedulers.computation())
                    .doOnComplete(() -> userService.updateStatus(img.getUuid(), Constants.Status.COMPLETE))
                    .subscribe((data) -> {
                        userService.saveMushafDetails(data);
                        ProcessImages.doProcess(data);
                    }, (e) -> {
                        userService.updateStatus(img.getUuid(), Constants.Status.ERROR);
                        logger.error(e.getMessage());
                    });

            return img;
        }, json());
    }
}
