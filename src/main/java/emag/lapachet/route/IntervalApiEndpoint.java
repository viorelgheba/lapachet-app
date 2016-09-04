package emag.lapachet.route;

import emag.lapachet.service.SqlInterval;
import spark.Service;
import static emag.lapachet.util.JsonUtil.json;

public class IntervalApiEndpoint implements EndpointInterface {

    private SqlInterval sqlInterval;

    public IntervalApiEndpoint()
    {
        this.sqlInterval = new SqlInterval();
    }

    @Override
    public void configure(Service spark) {
        spark.get("/api/intervals", (req, res) -> {
            res.type("application/json");
            return sqlInterval.getAvailableIntervals(req.queryMap("date").value());
        }, json());
    }
}
