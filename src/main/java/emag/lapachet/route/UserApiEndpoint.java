package emag.lapachet.route;

import com.google.gson.Gson;
import emag.lapachet.entity.SaveUser;
import emag.lapachet.service.SqlUser;
import spark.Service;

/**
 * Created by viorel.gheba on 9/4/16.
 */
public class UserApiEndpoint implements EndpointInterface {

    public static final Gson GSON;

    static {
        GSON = new Gson();
    }

    private SqlUser sqlUser;

    public UserApiEndpoint() {
        this.sqlUser = new SqlUser();
    }

    @Override
    public void configure(Service spark) {
        spark.post("/api/users", (req, res) -> {
            String token = System.getenv("BOT_API_TOKEN");
            if (!token.equals(req.queryMap("access_token").value())) {
                return "Invalid validation token";
            }

            SaveUser saveUser = GSON.fromJson(req.body(), SaveUser.class);
            return sqlUser.addUser(saveUser);
        });

        spark.get("/api/notify_users", (req, res) -> {
            sqlUser.notifyAllUsers();
            return "OK";
        });
    }
}
