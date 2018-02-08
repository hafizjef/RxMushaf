package frontEnd.apiController;

import Utils.ResponseError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Utils.JsonTransformer.toJson;
import static spark.Spark.after;
import static spark.Spark.notFound;

abstract class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    BaseController() {
        after((req, res) -> res.type("application/json"));
        notFound((req, res) -> toJson(new ResponseError("%s - Route Not Found", req.pathInfo())));
    }
}
