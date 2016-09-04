package emag.lapachet.route;

import emag.lapachet.service.SqlProduct;
import spark.Service;
import static emag.lapachet.util.JsonUtil.json;

public class ProductApiEndpoint implements EndpointInterface {

    private SqlProduct sqlProducts;

    public ProductApiEndpoint() {
        this.sqlProducts = new SqlProduct();
    }

    @Override
    public void configure(Service spark) {
        spark.get("/api/products", (req, res) -> {
            res.type("application/json");
            return sqlProducts.getAllProducts();
        }, json());

        spark.get("/api/products/:id", (req, res) -> {
            res.type("application/json");
            return sqlProducts.getProduct(Integer.valueOf(req.params(":id")));
        }, json());

        spark.get("/api/products_menus", (req, res) -> {
            res.type("application/json");
            return sqlProducts.getCategoryProducts(req.queryMap("date").value());
        }, json());

        spark.get("/api/category_products", (req, res) -> {
            res.type("application/json");
            return sqlProducts.getCategoryProducts(req.queryMap("date").value(), Integer.parseInt(req.queryMap("categoryId").value()));
        }, json());
    }
}
