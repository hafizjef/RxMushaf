package frontEnd.apiService;

import database.MySqlDatabase;
import model.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;

public class ReportService {

    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    public void addReport(Report report) {
        try {
            logger.debug(report.getComplainantEmail());
            MySqlDatabase.insertReport(report);
        } catch (SQLException | IOException err) {
            logger.error(err.getMessage());
        }
    }
}
