package emag.lapachet.route;

import emag.lapachet.service.SqlProduct;
import spark.Service;
import static emag.lapachet.util.JsonUtil.json;

public class ProductApiEndpoint extends AbstractEndpoint {

    private SqlProduct sqlProducts;

    public ProductApiEndpoint(String basePath) {
        super(basePath);
        this.sqlProducts = new SqlProduct();
    }

    @Override
    public void configure(Service spark) {
        spark.get(basePath + "/", (req, res) -> {
            res.type("application/json");
            return sqlProducts.getAllProducts();
        }, json());

        spark.get(basePath + "/:id", (req, res) -> {
            res.type("application/json");
            return sqlProducts.getProduct(Integer.valueOf(req.params(":id")));
        }, json());
    }
}
