package frontEnd.apiController;

import frontEnd.apiService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.util.UUID;

import static Utils.JsonTransformer.json;
import static spark.Spark.get;

public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(final UserService userService) {

        get("/user/:email", (Request req, Response res) -> {
            String email = req.params(":email");
            logger.debug("Requesting list for - {}", email);
            return userService.getMushaf(email);
        }, json());

        get("/details/:uuid", (req, res) -> {
            String uuid = req.params(":uuid");
            logger.debug("Requesting details for - {}", uuid);
            return userService.getData(UUID.fromString(uuid));
        }, json());
    }
}
