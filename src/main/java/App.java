import Utils.Constants;
import frontEnd.apiController.ProcessController;
import frontEnd.apiController.UserController;
import frontEnd.apiService.UserService;
import spark.Spark;
import spark.servlet.SparkApplication;

import static Utils.Constants.uploadDir;
import static spark.Spark.port;

public class App implements SparkApplication {


    public static void main(String args[]) {
    	port(8888);
        new UserController(new UserService());
        new ProcessController();
    }

	@Override
	public void init() {
        uploadDir.mkdirs();
        Spark.staticFiles.externalLocation(Constants.UPLOAD_DIR);
	}
}
