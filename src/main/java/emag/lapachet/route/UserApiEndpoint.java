package emag.lapachet.route;

import emag.lapachet.service.SqlUser;
import spark.Service;

/**
 * Created by viorel.gheba on 9/4/16.
 */
public class UserApiEndpoint implements EndpointInterface {

    private SqlUser sqlUser;

    public UserApiEndpoint() {
        this.sqlUser = new SqlUser();
    }

    @Override
    public void configure(Service spark) {
        spark.post("/api/users", (req, res) -> {
            return sqlUser.addUser(req.queryMap("user_id").value());
        });
    }
}
