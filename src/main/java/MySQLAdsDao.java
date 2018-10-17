import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Ad> all() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ads");

            ArrayList<Ad> ads = new ArrayList<>();
            while (rs.next()) {
                Ad ad = new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description"));
                ads.add(ad);
            }
            return ads;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Long insert(Ad ad) {
        try {
            Statement statement = connection.createStatement();
            String sql = "insert into ads(user_id, title, description) values (" + ad.getUserId() + ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')";
            System.out.println(sql);
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new RuntimeException("something went wrong!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
