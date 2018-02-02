package frontEnd.apiController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static responseTransformer.JsonTransformer.toJson;
import static spark.Spark.after;
import static spark.Spark.notFound;

abstract class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    BaseController() {
        after((req, res) -> res.type("application/json"));

        notFound((req, res) -> {
            logger.error("{} - Resource Not Found", req.pathInfo());
            res.type("application/json");
            return toJson("ERROR : NOT FOUND");
        });
    }
}
