package emag.lapachet.route;

import emag.lapachet.service.SqlCategory;
import spark.Service;

import java.text.SimpleDateFormat;

import static emag.lapachet.util.JsonUtil.json;

public class CategoryApiEndpoint extends AbstractEndpoint {
    private SqlCategory sqlCategory;

    public CategoryApiEndpoint(String basePath) {
        super(basePath);
        this.sqlCategory = new SqlCategory();
    }

    @Override
    public void configure(Service spark) {
        spark.get(basePath + "/daily", (req, res) -> {
            res.type("application/json");
            return sqlCategory.getDailyCategories(req.queryMap("date").value());
        }, json());
    }
}
