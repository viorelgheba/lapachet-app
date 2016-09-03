package emag.lapachet.util;

import org.sql2o.Sql2o;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by viorel.gheba on 9/4/16.
 */
public class Db {
    //public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-54-75-232-50.eu-west-1.compute.amazonaws.com:5432/d2mjejso35m3id", "dorrhamegyiqwt", "YydLmRffMrDfRNxh8SPHYlssKR");

    public static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        //URI dbUri = new URI("postgres://dorrhamegyiqwt:YydLmRffMrDfRNxh8SPHYlssKR@ec2-54-75-232-50.eu-west-1.compute.amazonaws.com:5432/d2mjejso35m3id");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
}
