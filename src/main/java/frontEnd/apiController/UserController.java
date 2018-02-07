package frontEnd.apiController;

import frontEnd.apiService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import static Utils.JsonTransformer.json;
import static spark.Spark.get;

public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(final UserService userService) {

        get("/user/:id", (Request req, Response res) -> {
            String id = req.params(":id");
            logger.info("test");
            return userService.getMushaf(id);
        }, json());
    }
}
