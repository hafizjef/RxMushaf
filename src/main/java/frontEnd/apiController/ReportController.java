package frontEnd.apiController;

import Utils.ResponseError;
import com.google.gson.Gson;
import frontEnd.apiService.ReportService;
import model.Report;
import model.Response;
import model.TestResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Utils.JsonTransformer.json;
import static spark.Spark.post;

public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    public ReportController(final ReportService reportService) {

        post("/report", "application/json", (req, res) -> {
            Gson gson = new Gson();
            //Report report = gson.fromJson(req.body(), Report.class);
            TestResp resp = gson.fromJson(req.body(), TestResp.class);
            logger.error(resp.toString());
            try {
                //reportService.addReport(report);
            } catch (Exception err) {
                logger.error(err.getMessage());
                return new ResponseError("Error, Malformed Request");
            }
            return new Response("200", "OK");
        }, json());
    }
}
