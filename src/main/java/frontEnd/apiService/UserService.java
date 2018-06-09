package frontEnd.apiService;

import Utils.Constants;
import Utils.DataFinder;
import Utils.Email;
import database.DMLsql;
import database.Mukasurat_DBModel;
import database.Mushafalquran_DBModel;
import database.MySqlDatabase;
import model.DetailedResult;
import model.ImageModel;
import model.ModelPageResult;
import net.sargue.mailgun.Configuration;
import net.sargue.mailgun.Mail;
import org.eclipse.jetty.server.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.*;
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
            String sql = "SELECT fileName, similarity FROM mobileuser WHERE jobId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, uuid.toString());

            ResultSet rs = ps.executeQuery();
            rs.first();

            String fileName = rs.getString(1);
            String model = rs.getString(2);

            ModelPageResult modelPageResult = new ModelPageResult();

            if(model.equalsIgnoreCase("NONE") || model.equalsIgnoreCase("")) {
                logger.error("No similarities record found");
            } else {
                DMLsql dmlSelectPage = new DMLsql();
                ArrayList<Mukasurat_DBModel> pagesModel = dmlSelectPage.selectPage(model);

                int mushafId = 0;
                for(Mukasurat_DBModel pageModel : pagesModel)
                {
                    mushafId = pageModel.getMushaf();
                    //Bean_Feature beansPage = pageModel.getBean_Feature();
                    //type = beansPage.getType();
                }

                ArrayList<Mushafalquran_DBModel> mushafalquranResultArray;
                Mushafalquran_DBModel objMushafalquran = new Mushafalquran_DBModel();
                objMushafalquran.setMushafId(mushafId);
                mushafalquranResultArray = dmlSelectPage.searchMushafalquran(objMushafalquran);

                modelPageResult.setMukaSurat(mushafalquranResultArray.get(0).getMukaSurat());
                modelPageResult.setNamaFail(mushafalquranResultArray.get(0).getNamaFail());
                modelPageResult.setMushafId(mushafalquranResultArray.get(0).getMushafId());
                modelPageResult.setDirektori(mushafalquranResultArray.get(0).getDirektori());
                modelPageResult.setNegara(mushafalquranResultArray.get(0).getNegara());
                modelPageResult.setPenerbit(mushafalquranResultArray.get(0).getPenerbit());
                modelPageResult.setPenyalin(mushafalquranResultArray.get(0).getPenyalin());
                modelPageResult.setTahunDisahkan(mushafalquranResultArray.get(0).getTahunDisahkan());
                modelPageResult.setVersi(mushafalquranResultArray.get(0).getVersi());
                modelPageResult.setTahunPenerbitan(mushafalquranResultArray.get(0).getTahunPenerbitan());

            }

            detailedResult.setResult(modelPageResult);
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

    public void updateStatus(ImageModel img, Constants.Status status) {
        try (
                Connection conn = MySqlDatabase.doConnection()
        ) {
            String sql = "UPDATE mobileuser SET status = ?, similarity = ?, weight = ? WHERE jobId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, status.toString());
            ps.setString(2, img.getModelName());
            ps.setDouble(3, img.getWeight());
            ps.setString(4, img.getUuid().toString());

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

            logger.debug("Data recorded - {}", data.getEmail());

        } catch (SQLException err) {
            logger.error(err.getMessage());
        }
    }

    private static Configuration config = new Configuration()
            .domain("-")
            .apiKey("-")
            .from("-");

    public void sendNotification(ImageModel data) {
        if (Email.validate(data.getEmail())) {
            Mail.using(config)
                    .to(data.getEmail())
                    .subject("TasMuq Processing Notification")
                    .text(String.format("Your Request on %s Have Been Processed\nStatus: %s", data.getTimestamp(), data.getStatus()))
                    .build()
                    .send();
            logger.info("Notification Sent To: {}", data.getEmail());
        } else {
            logger.error("Error - Invalid email address!");
        }
    }
}
