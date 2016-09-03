package emag.lapachet.api;

import com.google.gson.Gson;
import emag.lapachet.service.GenericList;
import emag.lapachet.service.ResponseError;
import emag.lapachet.service.SqlProducts;
import spark.Response;
import spark.ResponseTransformer;

import static emag.lapachet.service.JsonUtil.*;
import static spark.Spark.*;

class ApiProducts {
    ApiProducts(final SqlProducts sqlProducts) {
        get("/products", (request, response) -> {
            GenericList products = sqlProducts.getAllProducts();
            response.type("application/json");
            if (null != products) {
                return products;
            }

            response.status(401);
            return new ResponseError("Eroare");
        }, json());
    }
}
