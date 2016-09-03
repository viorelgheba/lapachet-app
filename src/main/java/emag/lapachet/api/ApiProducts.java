package emag.lapachet.api;

import emag.lapachet.entity.Products;
import emag.lapachet.service.GenericList;
import emag.lapachet.service.ResponseError;
import emag.lapachet.service.SqlProducts;

import static emag.lapachet.service.JsonUtil.*;
import static spark.Spark.*;

public class ApiProducts {
    public ApiProducts(final SqlProducts sqlProducts) {
        get("/products", (request, response) -> {
            response.type("application/json");
            GenericList products = sqlProducts.getAllProducts();

            return products;
        }, json());

        get("/products/:id", (request, response) -> {
            response.type("application/json");
            String id = request.params(":id");
            Products product = sqlProducts.getProduct(id);
            if (null != product) {
                return product;
            }

            return new ResponseError("Error, product with id '%s' not found", id);
        }, json());
    }
}
