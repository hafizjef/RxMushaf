import Utils.Constants;
import frontEnd.apiController.ProcessController;
import frontEnd.apiController.UserController;
import frontEnd.apiService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;
import spark.servlet.SparkApplication;

import static Utils.Constants.uploadDir;
import static spark.Spark.port;

public class App implements SparkApplication {

    private static final Logger logger = LoggerFactory.getLogger(SparkApplication.class);

    public static void main(String args[]) {
    	port(8888);
        logger.info("APPLICATION INIT HIT");
        uploadDir.mkdirs();
        new UserController(new UserService());
        new ProcessController(new UserService());
    }

	@Override
	public void init() {
        Spark.staticFiles.externalLocation(Constants.UPLOAD_DIR);
	}
}
