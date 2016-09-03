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
            GenericList products = sqlProducts.getAllProducts();
            response.type("application/json");

            return products;
        }, json());

        get("/products/:id", (request, response) -> {
            String id = request.params(":id");
            Products product = sqlProducts.getProduct(id);
            if (null != product) {
                return product;
            }

            return new ResponseError("Error, product with id '%s' not found", id);
        }, json());
    }
}
