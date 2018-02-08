package frontEnd.apiService;

import Utils.Constants;
import Utils.DataFinder;
import database.MySqlDatabase;
import model.DetailedResult;
import model.ImageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public DetailedResult getData(UUID uuid) {

        DetailedResult detailedResult = new DetailedResult(uuid);

        try (
                Connection conn = MySqlDatabase.doConnection()
        ) {
            String sql = "SELECT fileName FROM mobileuser WHERE jobId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, uuid.toString());

            ResultSet rs = ps.executeQuery();

            rs.first();

            String fileName = rs.getString(1);

            logger.info("Got {} from Database", fileName);

           detailedResult.setVerseList(DataFinder.findAllVerses(fileName));
           detailedResult.setOverlapList(DataFinder.findAllOverlap(fileName));

        } catch (SQLException err) {
            logger.error(err.getMessage());
        }

        return detailedResult;
    }

    public model.Result getMushaf(String userEmail) {
        model.Result result = new model.Result(userEmail);
        try (
                Connection conn = MySqlDatabase.doConnection()
        ) {
            String sql = "SELECT * FROM mobileuser WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userEmail);

            ResultSet rs = ps.executeQuery();

            List<ImageModel> imageModels = new ArrayList<>();

            while (rs.next()) {
                ImageModel model = new ImageModel();
                model.setEmail(userEmail);
                model.setmFile(new File(rs.getString("fileName")));
                model.setStatus(Constants.Status.valueOf(rs.getString("status")));
                model.setUuid(rs.getString("jobId"));
                model.setTimestamp(rs.getTimestamp("timestamp"));
                imageModels.add(model);
            }

            result.setImageModels(imageModels);
            return result;

        } catch (SQLException err) {
            logger.error(err.getMessage());
            return result;
        }
    }

    public void updateStatus(UUID uuid, Constants.Status status) {
        try (
                Connection conn = MySqlDatabase.doConnection()
        ) {
            String sql = "UPDATE mobileuser SET status = ? WHERE jobId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, status.toString());
            ps.setString(2, uuid.toString());

            ps.executeUpdate();

        } catch (SQLException err) {
            logger.error(err.getMessage());
        }
    }

    public void saveMushafDetails(ImageModel data) {
        try (
                Connection conn = MySqlDatabase.doConnection()
        ) {
            String sql = "INSERT INTO mobileuser (email, jobId, status, fileName, timestamp) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, data.getEmail());
            ps.setString(2, data.getUuid().toString());
            ps.setString(3, data.getStatus().toString());
            ps.setString(4, data.getmFile().getName());
            ps.setTimestamp(5, data.getTimestamp());
            ps.execute();

            logger.info("Data recorded - {}", data.getEmail());

        } catch (SQLException err) {
            logger.error(err.getMessage());
        }
    }
}
