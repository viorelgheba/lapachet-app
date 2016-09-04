package emag.lapachet.route;

import emag.lapachet.service.SqlCategory;
import spark.Service;

import java.text.SimpleDateFormat;

import static emag.lapachet.util.JsonUtil.json;

public class CategoryApiEndpoint implements EndpointInterface {
    private SqlCategory sqlCategory;

    public CategoryApiEndpoint() {
        this.sqlCategory = new SqlCategory();
    }

    @Override
    public void configure(Service spark) {
        spark.get("/api/categories/daily", (req, res) -> {
            res.type("application/json");
            return sqlCategory.getDailyCategories(req.queryMap("date").value());
        }, json());
    }
}
