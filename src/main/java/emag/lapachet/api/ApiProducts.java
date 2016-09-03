package emag.lapachet.api;

import emag.lapachet.entity.Product;
import emag.lapachet.util.GenericList;
import emag.lapachet.util.ResponseError;
import emag.lapachet.service.SqlProducts;

import java.util.List;

import static emag.lapachet.util.JsonUtil.*;
import static spark.Spark.*;

public class ApiProducts {
    public ApiProducts(final SqlProducts sqlProducts) {
        get("/products", (request, response) -> {
            response.type("application/json");

            return (List) sqlProducts.getAllProducts();
        }, json());

        get("/products/:id", (request, response) -> {
            response.type("application/json");
            Integer id = Integer.parseInt(request.params(":id"));
            Product product = sqlProducts.getProduct(id);
            if (null != product) {
                return product;
            }

            return new ResponseError("Error, product with id '%s' not found", request.params(":id"));
        }, json());
    }
}
