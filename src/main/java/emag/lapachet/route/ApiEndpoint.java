package emag.lapachet.route;

import static emag.lapachet.util.JsonUtil.*;
import emag.lapachet.service.SqlProducts;
import spark.Service;

public class ApiEndpoint extends AbstractEndpoint {

    private SqlProducts sqlProducts;

    public ApiEndpoint(String basePath) {
        super(basePath);
        this.sqlProducts = new SqlProducts();
    }

    @Override
    public void configure(Service spark) {
        spark.get(basePath + "/products", (req, res) -> {
            res.type("application/json");
            return sqlProducts.getAllProducts();
        }, json());
    }
}
